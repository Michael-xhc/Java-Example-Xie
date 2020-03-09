package cn.com.sinosafe.xiecommon.commonService;

import cn.com.sinosafe.agent.common.code.AgentResponseCode;
import cn.com.sinosafe.agent.common.exception.BusinessException;
import cn.com.sinosafe.agent.common.utils.HttpUtil;
import cn.com.sinosafe.agent.common.utils.JSONUtils;
import cn.com.sinosafe.agent.common.utils.ParamUtils;
import cn.com.sinosafe.agent.common.utils.SystemConfigUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.sinosafe.service.cmis.CopAppApplyService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @PACKAGE_NAME: cn.com.sinosafe.agent.common.commonService
 * @NAME: CommonService
 * @description: 公共服务类
 * @USER: xiehanchun
 * @time: 2020/2/12 16:34
 * @Version 1.0
 **/
@Service
public class CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonService.class);
	
	@Reference(timeout = 30000, retries = 0)
    private CopAppApplyService copAppApplyService;
    @Autowired
    private SystemConfigUtils systemConfigUtils;
	
	/**
	 * @Title: getManagerInfoByPhone   
	 * @Description: 根据手机号查询客户经理信息   
	 * @param: phone
	 * @return: Map<String,String>      
	 * @throws
	 */
	public JSONObject getManagerInfoByPhone(String phone){
		JSONObject mgrInfoJson = null;
        try {
        	JSONObject reqJson = new JSONObject();
        	reqJson.put("managerPhone", phone);
            long beginTime = System.currentTimeMillis();
            String rspInfo = copAppApplyService.queryCusMgerInfo(reqJson.toJSONString());
            long endTime = System.currentTimeMillis();
            logger.info("查询华安客户经理信息, 耗时[{}]毫秒, 入参:{}, 返回值:rspInfo={}", endTime - beginTime, reqJson.toJSONString(), rspInfo);
            mgrInfoJson = JSONObject.parseObject(rspInfo);
            // 客户经理姓名
            if (mgrInfoJson.getString("returnCode").equals("0000") && StringUtils.isNotBlank(mgrInfoJson.getString("mgerName"))
            // 客户经理所在机构
                && StringUtils.isNotBlank(mgrInfoJson.getString("orgId"))
                // 所在机构名称
                && StringUtils.isNotBlank(mgrInfoJson.getString("orgName"))) {

                return mgrInfoJson;
            }
            if("7777".equals(mgrInfoJson.getString("returnCode"))){
            	throw new BusinessException(AgentResponseCode.MANAGER_UN_DISABLE);
            }

            logger.error("查询华安客户经理信息不存在");
            return null;
        } catch (Exception e) {
        	logger.error("查询华安客户经理信息失败.", e);
            throw e;
        }
	}

    /**
     * @Description: 四要素校验 姓名 身份证号 手机号码 银行卡号
     * @Param: [req] 姓名 身份证号 手机号码 银行卡号 流水号
     * @Return: boolean
     * @Author: xiehanchun
     * @Date: 2020/2/18
     */
    @SuppressWarnings("unchecked")
    public boolean verify4Melements(JSONObject req) throws Exception {

        boolean resultFlag = false;

        //验证参数
        ParamUtils.notNull(req, "req");
        String cusName = req.getString("cusName");
        String certNo = req.getString("certNo");
        String phone = req.getString("phone");
        String bankCardNo = req.getString("bankCardNo");
        String applyId = req.getString("applyId");
        ParamUtils.notEmpty(cusName, "cusName");
        ParamUtils.notEmpty(certNo, "certNo");
        ParamUtils.notEmpty(phone, "phone");
        ParamUtils.notEmpty(bankCardNo, "bankCardNo");
        ParamUtils.notEmpty(applyId, "applyId");

        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("name", cusName);
        reqMap.put("idcard", certNo);
        reqMap.put("mobile", phone);
        reqMap.put("bankcard", bankCardNo);
        reqMap.put("serno", applyId);
        logger.info("校验四要素的请求参数为{}", JSONUtils.getSingleInstance().toJSon(reqMap));

        long beginTime = System.currentTimeMillis();
        Map<String, Object> configMap = systemConfigUtils.getValue("GD_BIGDATA_URL");
        String url = (String)configMap.get("cop.h5.bigdata.url");
        String rspInfo = HttpUtil.sendPostWithJson(url, reqMap);
        long endTime = System.currentTimeMillis();

        logger.info("【校验四要素】 耗时[{}]毫秒, 输入参数:{}, 返回值:rspInfo={}", endTime - beginTime, JSONUtils.getSingleInstance().toJSon(reqMap), rspInfo);
//        Map<String, Object> checkResultMap = (Map<String, Object>)JSONObject.parse(rspInfo);
        JSONObject jsonObject = JSONObject.parseObject(rspInfo);
//        String code = Objects.toString(checkResultMap.get("code"));
        String code = jsonObject.getString("code");
//        String data = Objects.toString(checkResultMap.get("data"));
        String data =jsonObject.getString("data");
        // code 0 为调用成功 data 1一致，0不一致
        if (StringUtils.equals(code,"0")) {
            resultFlag = StringUtils.equals(data,"1");
        } else {
            throw new Exception( "调用校验接口异常"+jsonObject.getString("message"));
        }
        return resultFlag;
    }

    /**
     * @Description: 亚联所有接口-开户行识别
     * @Param: []
     * @Return: java.lang.String
     * @Author: xiehanchun
     * @Date: 2020/2/25
     */
    public JSONObject bankIdentification(JSONObject req) throws Exception{
        ParamUtils.notNull(req, "req");
        String bankCardNo = req.getString("bankCardNo");
        String applyId = req.getString("applyId");
        String type = req.getString("type");

        //校验参数
        ParamUtils.notEmpty(bankCardNo,"bankcard");
        ParamUtils.notEmpty(applyId,"applyId");
        ParamUtils.notEmpty(type,"type");

        Map<String,Object> reqMap = new HashMap<>();
        reqMap.put("bankcard",bankCardNo);
        reqMap.put("serno",applyId);
        reqMap.put("type",type);

        long beginTime = System.currentTimeMillis();
        Map<String, Object> configMap = systemConfigUtils.getValue("GD_BIGDATA_URL");
        String url = (String)configMap.get("cop.bankCode.bigdata.url");
        String rspInfo = HttpUtil.sendPostWithJson(url, reqMap);
        long endTime = System.currentTimeMillis();
        logger.info("【开户行识别】 耗时[{}]毫秒, 输入参数:{}, 返回值:rspInfo={}", endTime - beginTime, JSONUtils.getSingleInstance().toJSon(reqMap), rspInfo);

        JSONObject rsp = new JSONObject();
//        Map<String, Object> bankIdentificationMap1 = (Map<String, Object>)JSONObject.parse(rspInfo);
        JSONObject jsonObject = JSONObject.parseObject(rspInfo);
        logger.info("");
//        String code = Objects.toString(bankIdentificationMap1.get("code"));
        String code = jsonObject.getString("code");
//        String data = Objects.toString(bankIdentificationMap1.get("data"));
        // 0 调用成功
        if(StringUtils.equals(code,"0")){
            JSONObject dataInfo = jsonObject.getJSONObject("data");
//            Map<String, Object> bankIdentificationMap2 = (Map<String, Object>)JSONObject.parse(data);
            String result = dataInfo.getString("result");
//            String result = Objects.toString(bankIdentificationMap2.get("result"));
//            String data1 = Objects.toString(bankIdentificationMap2.get("data"));
            // 调用成功 0000
            if(StringUtils.equals(result,"0000")){
                JSONObject dataInfo1 = dataInfo.getJSONObject("data");
//                Map<String, Object> bankIdentificationMap3 = (Map<String, Object>)JSONObject.parse(data1);
                String bankName = Objects.toString(dataInfo1.getString("bank_description"));
                rsp.put("bankName",bankName);
                String bankCode = Objects.toString(dataInfo1.getString("bank_id"));
                rsp.put("bankCode",bankCode);
                logger.info("【开户行识别】 开户行名称 {} 开户行编码{}",bankName,bankCode);
            }else {
                throw new BusinessException( "调用校验接口异常"+Objects.toString(dataInfo.get("msg")));
            }
        }else {
            throw new BusinessException( "调用校验接口异常"+Objects.toString(jsonObject.get("message")));
        }
        return rsp;
    }
}
