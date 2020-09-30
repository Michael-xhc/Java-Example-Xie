/*
package cn.com.sinosafe.xiecommon.config;

import cn.com.sinosafe.xiecommon.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.sinosafe.credit2.CreditInfo;
import com.sinosafe.credit2.domain.TPerCreditQueryDetail;
import com.sinosafe.credit2.domain.TPerCreditTransBasic;
import com.sinosafe.credit2.domain.TPerCreditTransLastest;
import com.sinosafe.credit2.domain.TPerCreditTransRecent;
import com.sinosafe.credit2.utils.LoanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

*/
/**
 * 查询个人征信数据汇总
 * Created by xiehanchun on 2020/7/22
 *//*

@Service
@Slf4j
public class QueryCreditSummaryInfoService {
    private final static int DEF_DIV_SCALE = 2;
    private final static String TYPE_D1 = "D1";

    @Autowired
//    protected Credit2FeignClient feignClient;

    public JSONObject queryCreditSummaryInfo(Credit2FeignClient.RequestForm rquestForm) throws Exception{
        //校验参数
//        BigDataUtils.checkParam(rquestForm.getBusinessId(), "征信查询流水号不能为空");
//        BigDataUtils.checkParam(rquestForm.getIdentityNo(), "身份证不能为空");
//        BigDataUtils.checkParam(rquestForm.getUserName(), "姓名不能为空");

//        rquestForm.setReadNew("N");
        log.info("查询个人征信数据汇总入参："+ rquestForm);
//        String credit2Result = feignClient.reportQuery(rquestForm);
        String credit2Result = "";
        //截取一部分
        String logStr = (StringUtils.isNotBlank(credit2Result)== true && credit2Result.length() > 1000 ) ?
                credit2Result.substring(0,1000) : credit2Result;
        log.info("请求二代征信微服务出参："+ logStr);
        JSONObject content = JSONObject.parseObject(credit2Result);

        CreditInfo creditInfo = null;
        //返回参数
        JSONObject result = new JSONObject();
        //征信查询次数
        JSONObject queryCreditJson = new JSONObject();
        //贷款逾期次数
        JSONObject loanOverdueJson = new JSONObject();
        if(content.containsKey("data")){
            JSONObject data = JSONObject.parseObject(content.getString("data"));
            if(data.containsKey("content")){
                creditInfo = JSONObject.parseObject(data.getString("content").replace("--", "0"),
                        com.sinosafe.credit2.CreditInfo.class);
            }
        }
        // R2 贷记卡 D1 信用卡  R3 准贷记卡
        if(!ObjectUtils.isEmpty(creditInfo)){
            //未结清抵押贷款
            if(!ObjectUtils.isEmpty(creditInfo.getTransBasic()) && !ObjectUtils.isEmpty(creditInfo.getTransRecent())){
                List<TPerCreditTransRecent> tPerCreditTransRecentList = creditInfo.getTransRecent().stream()
                        .filter(e -> "D1".equals(e.getAccountType()))
                        .collect(Collectors.toList());

                long unMortgageNum = creditInfo.getTransBasic().stream().filter((e)->{
                    if("D1".equals(e.getType()) && "抵押".equals(e.getGuaranteeWay())){
                        return true;
                    }
                    if("D1".equals(e.getType()) && "组合担保（不含保证）".equals(e.getGuaranteeWay())){
                        return true;
                    }
                    return false;
                }).filter((e)-> tPerCreditTransRecentList.stream().map(e2->e2.getAccountNo())
                                .collect(Collectors.toList())
                                .contains(e.getAccountNo())
                ).count();
                //总笔数
                result.put("unMortgageNum", unMortgageNum);

                List<TPerCreditTransBasic> tPerCreditTransBasicList = creditInfo.getTransBasic().stream().filter((e) -> {
                    if ("D1".equals(e.getType()) && "抵押".equals(e.getGuaranteeWay())) {
                        return true;
                    }
                    if ("D1".equals(e.getType()) && "组合担保（不含保证）".equals(e.getGuaranteeWay())) {
                        return true;
                    }
                    return false;
                }).collect(Collectors.toList());

                double unMortgageSumAccount = creditInfo.getTransRecent().stream().filter(e -> "D1".equals(e.getAccountType()))
                        .filter((e) -> tPerCreditTransBasicList.stream().map(e1 -> e1.getAccountNo())
                                .collect(Collectors.toList())
                                .contains(e.getAccountNo())
                        ).mapToDouble(e2 -> e2.getAmount().doubleValue()
                        ).sum();
                //总余额
                result.put("unMortgageSumAccount", unMortgageSumAccount);


                //未结清信用贷款
                List<TPerCreditTransRecent> tPerCreditTransRecentList1 = creditInfo.getTransRecent().stream()
                        .filter(e -> "D1".equals(e.getAccountType()))
                        .collect(Collectors.toList());

                long unCreditNum = creditInfo.getTransBasic().stream().filter((e) -> {
                    if ("D1".equals(e.getType()) && "信用/免担保".equals(e.getGuaranteeWay())) {
                        return true;
                    }
                    if ("D1".equals(e.getType()) && "组合担保（含保证）".equals(e.getGuaranteeWay())) {
                        return true;
                    }
                    return false;
                }).filter((e) -> tPerCreditTransRecentList1.stream().map(e2 -> e2.getAccountNo())
                        .collect(Collectors.toList())
                        .contains(e.getAccountNo())
                ).count();
                //总笔数
                result.put("unCreditNum", unCreditNum);

                List<TPerCreditTransBasic> tPerCreditTransBasicList2 = creditInfo.getTransBasic().stream().filter((e) -> {
                    if ("D1".equals(e.getType()) && "信用/免担保".equals(e.getGuaranteeWay())) {
                        return true;
                    }
                    if ("D1".equals(e.getType()) && "组合担保（含保证）".equals(e.getGuaranteeWay())) {
                        return true;
                    }
                    return false;
                }).collect(Collectors.toList());

                double unCreditSumAccount = creditInfo.getTransRecent().stream().filter(e -> "D1".equals(e.getAccountType()))
                        .filter((e) -> tPerCreditTransBasicList2.stream().map(e1 -> e1.getAccountNo())
                                .collect(Collectors.toList())
                                .contains(e.getAccountNo())
                        ).mapToDouble(e2 -> e2.getAmount().doubleValue()
                        ).sum();
                //总余额
                result.put("unCreditSumAccount", unCreditSumAccount);

                List<TPerCreditTransRecent> tPerCreditTransRecentList3 = creditInfo.getTransRecent().stream()
                        .filter(e -> "D1".equals(e.getAccountType()))
                        .collect(Collectors.toList());

                double totalLoanAmount = creditInfo.getTransBasic().stream().filter((e) -> {
                    if ("D1".equals(e.getType()) && "信用/免担保".equals(e.getGuaranteeWay())) {
                        return true;
                    }
                    if ("D1".equals(e.getType()) && "组合担保（含保证）".equals(e.getGuaranteeWay())) {
                        return true;
                    }
                    return false;
                }).filter((e) -> tPerCreditTransRecentList3.stream().map(e2 -> e2.getAccountNo())
                        .collect(Collectors.toList())
                        .contains(e.getAccountNo())
                ).mapToDouble(e3 -> e3.getLoanAmount().doubleValue()
                ).sum();
                //贷款总额
                result.put("totalLoanAmount", new BigDecimal(totalLoanAmount));
            }

            //未销户信用卡
            if(!ObjectUtils.isEmpty(creditInfo.getLoanCards())) {
                //授信总额
                Double creditAccount = creditInfo.getLoanCards().stream()
                        .filter(loanCard -> "1,2".contains(loanCard.getType()))
                        .mapToDouble(loanCard -> loanCard.getTotalCredit().doubleValue())
                        .sum();
                result.put("creditAccount", creditAccount);

                //最近6个月平均使用额度（元）
                Double creditCardIn6MonthAccount = creditInfo.getLoanCards().stream()
                        .filter(loanAccount->"1,2".contains(loanAccount.getType()))
                        .mapToDouble(loanAccount->loanAccount.getLastCredit().doubleValue())
                        .sum();
                result.put("creditCardIn6MonthAccount", creditCardIn6MonthAccount);

                //总使用率
                if(creditAccount > 0) {
                    int totalUtilization = new BigDecimal(creditCardIn6MonthAccount)
                            .divide(new BigDecimal(creditAccount), DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP)
                            .intValue();
                    result.put("totalUtilization", totalUtilization);
                }
            }

            //单张卡最大使用率 贷记卡是R2 准贷记卡是R3
            if(!ObjectUtils.isEmpty(creditInfo.getTransBasic()) && !ObjectUtils.isEmpty(creditInfo.getTransRecent())){
                //单张卡总账户授信额度
                double totalAccountAmount = creditInfo.getTransBasic().stream().filter(e -> "R2".equals(e.getType()) && "人民币元".equals(e.getCurrency()))
                        .mapToDouble(e -> e.getAccountAmount().doubleValue())
                        .sum();

                List<TPerCreditTransBasic> r2TPerCreditTransBasicList = creditInfo.getTransBasic().stream().filter(e -> "R2".equals(e.getType()) && "人民币元".equals(e.getCurrency()))
                        .collect(Collectors.toList());

                //单张卡总最近六个月平均使用额度
                double totalAveBalance = creditInfo.getTransRecent().stream().filter(e -> "R2".equals(e.getAccountType()))
                        .filter((e) -> r2TPerCreditTransBasicList.stream().map(TPerCreditTransBasic::getAccountNo)
                                .collect(Collectors.toList())
                                .contains(e.getAccountNo())
                        ).mapToDouble(e -> e.getAveBalance().doubleValue())
                        .sum();

                List<TPerCreditTransBasic> r3TPerCreditTransBasicList = creditInfo.getTransBasic().stream().filter(e -> "R3".equals(e.getType()) && "人民币元".equals(e.getCurrency()))
                        .collect(Collectors.toList());

                //单人民币账户准贷记卡近6个月平均透支余额
                double totalAveOverAmount6 = creditInfo.getTransRecent().stream().filter(e -> "R3".equals(e.getAccountType()))
                        .filter((e) -> r3TPerCreditTransBasicList.stream().map(TPerCreditTransBasic::getAccountNo)
                                .collect(Collectors.toList())
                                .contains(e.getAccountNo())
                        ).mapToDouble(e -> Double.parseDouble(e.getAveOverAmount6()))
                        .sum();

                //透支余额
                double totalOverAmountBalance1 = creditInfo.getTransRecent().stream().filter(e -> "R3".equals(e.getAccountType()))
                        .filter((e) -> r3TPerCreditTransBasicList.stream().map(TPerCreditTransBasic::getAccountNo)
                                .collect(Collectors.toList())
                                .contains(e.getAccountNo())
                        ).mapToDouble(e -> Double.parseDouble(e.getOverAmountBalance1()))
                        .sum();

                //单人民币账户贷记卡最近六个月平均使用额度/账户授信额度
                BigDecimal r2Proportion = new BigDecimal(0.00);
                if(totalAccountAmount > 0) {
                    r2Proportion = new BigDecimal(totalAveBalance).divide(new BigDecimal(totalAccountAmount), DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
                }
                //单人民币账户准贷记卡近6个月平均透支余额/透支余额）
                BigDecimal r3Proportion = new BigDecimal(0.00);
                if(totalOverAmountBalance1 > 0) {
                    r3Proportion = new BigDecimal(totalAveOverAmount6).divide(new BigDecimal(totalOverAmountBalance1), DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
                }
                //单张卡最大使用率 (MAX(单人民币账户贷记卡最近六个月平均使用额度/账户授信额度，单人民币账户准贷记卡近6个月平均透支余额/透支余额）)
                result.put("singleCardUtilization", r2Proportion.compareTo(r3Proportion) > 1 ? r2Proportion:r3Proportion);

                //贷（准）记卡 人民币账户数
                List<TPerCreditTransBasic> r2R3List = creditInfo.getTransBasic().stream().filter((e)->{
                    if("人民币元".equals(e.getType()) && "R2,R3".contains(e.getType())){
                        return  true;
                    }
                    return false;
                }).collect(Collectors.toList());
                //贷（准）记卡 正常的人民币账户数
                int count_normal = creditInfo.getTransRecent().stream().filter((e)->{
                    if("正常".equals(e.getStatus()) && "R2,R3".contains(e.getAccountType())){
                        return  true;
                    }
                    return  false;
                }).collect(Collectors.toList()).size();

                //贷（准）记卡 超过9成的人民币账户数
                int count_90 = creditInfo.getTransRecent().stream().filter((e)->{
                    if("正常".equals(e.getStatus()) && "R2,R3".contains(e.getAccountType())){
                        return true;
                    }
                    return false;
                }).filter((e)-> { r2R3List.stream().filter(e1 -> {
                    if (e1.getType().equals(e.getAccountType()) && e1.getAccountNo().equals(e.getAccountNo())) {
                        if (e.getAveBalance().divide(e1.getAccountAmount()).compareTo(new BigDecimal(0.9)) >= 0) {
                            return true;
                        }
                        if (new BigDecimal(e.getAveOverAmount6()).divide(e1.getAccountAmount()).compareTo(new BigDecimal(0.9)) >= 0) {
                            return true;
                        }
                        return false;
                    }
                    return false;
                });
                    return false;
                }).collect(Collectors.toList()).size();

                //高额使用卡占比(（单人民币账户使用率大于90%的账户数）/总账户数)
                BigDecimal ratio = new BigDecimal(count_90).divide(new BigDecimal(count_normal), DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP);
                result.put("ratio", ratio);
            }

            //非循环贷是D1
            if(!ObjectUtils.isEmpty(creditInfo.getLoanCards()) && !ObjectUtils.isEmpty(creditInfo.getTransRecent())){
                //“非循环贷账户”的“本月应还款”之和
                double totalShouldPay = creditInfo.getTransRecent().stream().filter(e -> "D1".equals(e.getAccountType()))
                        .mapToDouble(e -> e.getShouldPay().doubleValue())
                        .sum();

                //“贷记卡账户信息汇总”的“最近6个月平均使用额度”
                double totalLastCredit = creditInfo.getLoanCards().stream().filter(e -> "1".equals(e.getType()))
                        .mapToDouble(e -> e.getLastCredit().doubleValue())
                        .sum();
                //总月负债(“非循环贷账户”的“本月应还款”之和 +“贷记卡账户信息汇总”的“最近6个月平均使用额度”* 10%)
                BigDecimal totalMonDebt= new BigDecimal(totalShouldPay).add(new BigDecimal(totalLastCredit).multiply(new BigDecimal("0.1")));
                result.put("totalMonDebt", totalMonDebt);
            }

            //逾期次数
            // 近1个月
            long loanOverdueIn1Month = creditInfo.getTransHistory().stream().filter((e)->
                    LoanUtils.getOverdueOutCount(1, 1,e)>=1
            ).count();
            loanOverdueJson.put("loanOverdueIn1Month",loanOverdueIn1Month);
            //近3个月
            long loanOverdueIn3Month = creditInfo.getTransHistory().stream().filter((e)->
                    LoanUtils.getOverdueOutCount(3, 1,e)>=1
            ).count();
            loanOverdueJson.put("loanOverdueIn3Month",loanOverdueIn3Month);
            //近半年
            long loanOverdueIn6Month = creditInfo.getTransHistory().stream().filter((e)->
                    LoanUtils.getOverdueOutCount(6, 1,e)>=1
            ).count();
            loanOverdueJson.put("loanOverdueIn6Month",loanOverdueIn6Month);
            //近1年
            long loanOverdueI1Year = creditInfo.getTransHistory().stream().filter((e)->
                    LoanUtils.getOverdueOutCount(12, 1,e)>=1
            ).count();
            loanOverdueJson.put("loanOverdueI1Year",loanOverdueI1Year);
            //近2年
            long loanOverdueIn2Year = creditInfo.getTransHistory().stream().filter((e)->
                    LoanUtils.getOverdueOutCount(24, 1,e)>=1
            ).count();
            loanOverdueJson.put("loanOverdueIn2Year",loanOverdueIn2Year);
            result.put("loanOverdueJson",loanOverdueJson);


            //征信查询次数 (30天内同一机构相同原因查询算作一次)
            if(!ObjectUtils.isEmpty(creditInfo.getQueryDetail())){
                //近1个月
                int queryIn1Month = queryInMonth(creditInfo.getQueryDetail(), 1);
                */
/*int  queryIn1Month = CreditQueryUtils.getQueryCount(creditInfo, 1);*//*

                //近3个月
                int queryIn3Month = queryInMonth(creditInfo.getQueryDetail(), 3);
                */
/*int  queryIn3Month = CreditQueryUtils.getQueryCount(creditInfo, 3);*//*

                //近半年
                int queryIn6Month = queryInMonth(creditInfo.getQueryDetail(), 6);
                */
/*int  queryIn6Month = CreditQueryUtils.getQueryCount(creditInfo, 6);*//*

                //近1年
                int queryIn12Month = queryInMonth(creditInfo.getQueryDetail(), 12);
                */
/*int  queryIn12Month = CreditQueryUtils.getQueryCount(creditInfo, 12);*//*

                //近24年
                int queryIn24Month = queryInMonth(creditInfo.getQueryDetail(), 24);
                */
/*int  queryIn24Month = CreditQueryUtils.getQueryCount(creditInfo, 24);*//*

                queryCreditJson.put("queryIn1Month", queryIn1Month);
                queryCreditJson.put("queryIn3Month", queryIn3Month);
                queryCreditJson.put("queryIn6Month", queryIn6Month);
                queryCreditJson.put("queryIn12Month", queryIn12Month);
                queryCreditJson.put("queryIn24Month", queryIn24Month);
                result.put("queryCreditJson",queryCreditJson);
            }

            //未结清贷款详情
            if(!ObjectUtils.isEmpty(creditInfo.getTransLastest()) && !ObjectUtils.isEmpty(creditInfo.getTransBasic())) {
                Map<String, TPerCreditTransLastest> tPerCreditTransLasMap = creditInfo.getTransLastest().stream().filter(e -> "D1".equals(e.getAccountType()) && !"结清".equals(e.getStatus()))
                        .collect(Collectors.toMap(TPerCreditTransLastest::getAccountNo,e->e));

                List<TPerCreditTransBasic> tPerCreditTransBasicList = creditInfo.getTransBasic().stream().filter(e -> "D1".equals(e.getType()) && tPerCreditTransLasMap.containsKey(e.getAccountNo()))
                        .map((e) ->{
                            TPerCreditTransLastest tPerCreditTransLastest = tPerCreditTransLasMap.get(e.getAccountNo());
                            e.setClaimsTransferStatus(tPerCreditTransLastest.getStatus());
                            return e;
                        }).sorted(Comparator.comparing(TPerCreditTransBasic::getOpenDate).reversed())
                        .collect(Collectors.toList());

                result.put("tPerCreditTransBasicList", tPerCreditTransBasicList);

                //2年内已结清贷款详情
                Map<String, TPerCreditTransLastest> map = creditInfo.getTransLastest().stream().filter(e -> {
                    if ("D1".equals(e.getAccountType()) && "结清".equals(e.getStatus())) {
                        //当前日期 减 两年
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(new Date());
                        cal.add(Calendar.YEAR, -2);
                        //关闭日期
                        Date closeDate = getReportDate(e.getCloseDate(), "yyyy-MM-dd");
                        return closeDate.after(cal.getTime());
                    }
                    return false;
                }).collect(Collectors.toMap(TPerCreditTransLastest::getAccountNo,e->e));

                List<TPerCreditTransBasic> closeLoanfor2YearList = creditInfo.getTransBasic().stream()
                        .filter(e1 -> "D1".equals(e1.getType()) && map.containsKey(e1.getAccountNo()))
                        .map((e) -> {
                            TPerCreditTransLastest tPerCreditTransLastest = map.get(e.getAccountNo());
                            e.setEndDate(tPerCreditTransLastest.getCloseDate());
                            e.setClaimsTransferStatus(tPerCreditTransLastest.getStatus());
                            return e;
                        }).sorted(Comparator.comparing(TPerCreditTransBasic::getOpenDate).reversed())
                        .collect(Collectors.toList());

                result.put("closeLoanfor2YearList", closeLoanfor2YearList);
            }

            //征信查询申请详情
            if(!ObjectUtils.isEmpty(creditInfo.getQueryDetail())) {
                List<TPerCreditQueryDetail> tPerCreditQueryDetailList = creditInfo.getQueryDetail().stream()
                                                                                                   .sorted(Comparator.comparing(TPerCreditQueryDetail::getQueryDate).reversed())
                                                                                                   .collect(Collectors.toList());
                result.put("tPerCreditQueryDetailList", tPerCreditQueryDetailList);
            }
        }
        log.info("查询个人二代征信数据汇总出参："+ result.toString());

        return result;
    }

    */
/**
     * @Author xiehanchun
     * @Description //TODO
     * @Date 2020/7/24
     * @Param [list, month]
     * @return int
     **//*

    private int queryInMonth(List<TPerCreditQueryDetail> list,int month){
        int number = 0;
        if(month ==1){
            number =queryCreditInvesNum(list,month);
        }else {
            for(int i = 1; i <= month; i++){
                number += queryCreditInvesNum(list,i);
            }
            System.out.println("数量"+number);
        }
        return number;
    }


    */
/**
     * @Author xiehanchun
     * @Description //查询征信次数
     * @Date 2020/7/24
     * @Param [list]
     * @return int
     **//*

    private int queryCreditInvesNum(List<TPerCreditQueryDetail> list,int month){
        return list.stream()
                .filter(e -> {
                            //查询时间
                            Date reportDate = getReportDate(e.getReportid().substring(0, 8), "yyyyMMdd");
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(reportDate);
                            cal.add(Calendar.MONTH, -month);
                            //报告时间
                            Date queryDate = getReportDate(e.getQueryDate(), "yyyy-MM-dd");
                            return cal.getTime().before(queryDate);
                        }
                )
                .sorted(Comparator.comparing(TPerCreditQueryDetail::getQueryDate).reversed())
                .skip(
                        list.stream()
                                .filter(e -> {
                                    //查询时间
                                    Date reportDate = getReportDate(e.getReportid().substring(0, 8), "yyyyMMdd");
                                    Calendar cal = Calendar.getInstance();
                                    cal.setTime(reportDate);
                                    cal.add(Calendar.MONTH, -month+1);
                                    //报告时间
                                    Date queryDate = getReportDate(e.getQueryDate(), "yyyy-MM-dd");
                                    return cal.getTime().before(queryDate);
                                }).map((e) -> e.getOrgCode()).collect(Collectors.toList()).size()
                )
                .map((e) -> e.getOrgCode())
                .distinct()
                .collect(Collectors.toList())
                .size();
    }

    */
/**
     * @Author xiehanchun
     * @Description //日期格式化
     * @Date 2020/7/24
     * @Param [date, format]
     * @return java.util.Date
     **//*

    private static Date getReportDate(String date, String format)  {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        date = date.replace(".", "-");
        date = date.replace("/", "-");
        Date now = null;
        try {
            now = sdf.parse(date);
        } catch (ParseException e) {
            log.info("【个人征信数据汇总】日期格式化异常" +e.getMessage());
        }
        return now;
    }
}
*/
