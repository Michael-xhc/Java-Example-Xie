package cn.com.sinosafe.xiecommon.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @Project : agent-common
* @Desc    : 流水号生成器工具类
* @Author  : HuYang
* @Date    : 2020年2月20日 下午9:10:56
* @Version : 1.0
*/
public class SernoGeneratoUtils {

	/**
	* @Desc    : 佣金收入明细流水号,生成规则:DF+yyyyMMddHHmmssSSS+3位数字随机码
	* @Author  : HuYang
	* @Date    : 2020年2月20日 下午9:13:49
	* @return  :
	 */
	public static String getCommisionId(){
		return "DF".concat(DateUtils.getNowTimeMic()).concat(RandomUtils.getNumRandom(3));
	}

	/**
	* @Desc    : 账户交易明细流水号,生成规则:生成规则:TF+yyyyMMddHHmmssSSS+3位数字随机码
	* @Author  : HuYang
	* @Date    : 2020年2月22日 下午1:10:29
	* @return  :
	*/
	public static String getAccountTradeFlowId() {
		return "TF".concat(DateUtils.getNowTimeMic()).concat(RandomUtils.getNumRandom(3));
	}
	
	/**
	* @Desc    : 账户交易批次号 ,生成规则:B+yyyyMMddHHmmssSSS+3位数字随机码
	* @Author  : HuYang
	* @Date    : 2020年2月22日 下午5:19:17
	* @return  :
	 */
	public static String getAccountTradeBatchId() {
		return "B".concat(DateUtils.getNowTimeMic()).concat(RandomUtils.getNumRandom(3));
	}
	
	/**
	* @Desc    : 获取代理人注册流水号,生成规则:SG+YYYYMMDD+申请用户ID+2位随机数 示例:SG2020011710000088
	* @Author  : HuYang
	* @Date    : 2020年2月24日 下午9:50:20
	* @param userId
	* @return  :
	 */
	public static String getApplyId(Integer userId) {
		return "SG".concat(DateUtils.getNowDateWithOut()).concat(String.valueOf(userId)).concat(RandomUtils.getNumRandom(2));
	}
	
	/**
	* @Desc    : 生成用户ID,8开头的8位随机整数
	* @Author  : HuYang
	* @Date    : 2020年2月23日 下午10:01:58
	* @return  :
	 */
	public static Integer getUserId(){
		return Integer.valueOf(RandomUtils.randomInteger(8, 8));
	}
	
	/**   
	 * @Title: generateLoginToken   
	 * @Description: 获取登录token   
	 * @param: phoneNumber
	 * @return: String      
	 * @throws   
	 */
	public static String generateLoginToken(String phoneNumber) {
		StringBuilder sbToken = new StringBuilder();
        sbToken.append(AgentConstants.LOGIN_TOKEN_PREFIX).append(phoneNumber + "-")
            .append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "-").append(RandomUtils.randomNumbers(6));
        return DigestUtils.md5Hex(sbToken.toString());
	}
}
