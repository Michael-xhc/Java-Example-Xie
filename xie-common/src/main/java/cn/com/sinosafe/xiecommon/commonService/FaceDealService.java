/**
 * 
 */
package cn.com.sinosafe.xiecommon.commonService;

import cn.com.sinosafe.agent.common.code.AgentResponseCode;
import cn.com.sinosafe.agent.common.exception.BusinessException;
import cn.com.sinosafe.agent.common.utils.HttpUtil;
import cn.com.sinosafe.agent.common.utils.SystemConfigUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**  
* <p>Title: FaceFroWeixinService</p>  
* <p>Description: 人脸识别接口</p>  
* @author longxiaoqiang  
* @date 2020年2月24日  
*/
@Component
public class FaceDealService {
	
	private static final Logger logger = LoggerFactory.getLogger(FaceDealService.class);

	@Autowired
	SystemConfigUtils systemConfigUtils;
	/**
	 * <p>Title: faceDealForWeixin</p>  
	 * <p>Description: 获取微信人脸识别签名串</p>  
	 * @param url
	 * @return
	 */
	public Map<String, Object> faceDealForWeixin (String url) {
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("url", url);
		
		logger.info("微信人脸识别请求参数为：{}", JSONObject.toJSONString(params));
		
		Map<String, Object> value = systemConfigUtils.getValue("GD_FACE_DEAL_URL");
		String resUrl = (String)value.get("gd_face_deal_weixin");
		
		String rspJson = HttpUtil.sendPostWithJson(resUrl, params);
		
		logger.info("微信人脸识别返回信息：{}",rspJson);
		return (Map<String, Object>) JSONObject.parseObject(rspJson);
	}
	
	/**
	 * <p>Title: faceDealForToken</p>  
	 * <p>Description: 获取h5请求人脸识别的token</p>  
	 * @param userName
	 * @param certNo
	 * @param notifyUrl
	 * @return
	 */
	public Map<String, Object> faceDealForToken (String userName,String certNo,String notifyUrl) {
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("certNo", certNo);
		params.put("notifyUrl", notifyUrl);
		
		logger.info("获取h5请求人脸识别的token参数：{}", JSONObject.toJSONString(params));
		
		Map<String, Object> value = systemConfigUtils.getValue("GD_FACE_DEAL_URL");
		String resUrl = (String)value.get("gd_face_deal_token");
		
		String rspJson = HttpUtil.sendPostWithJson(resUrl, params);
		
		logger.info("获取h5请求人脸识别的token返回信息：{}",rspJson);
		return (Map<String, Object>) JSONObject.parseObject(rspJson);
	}
	/**
	 * <p>Title: getFaceDealResult</p>  
	 * <p>Description: 获取h5人脸识别结果</p>  
	 * @param bizId
	 * @return
	 */
	public Map<String, Object> getFaceDealResult (String bizId) {
		
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bizId", bizId);
		
		logger.info("获取h5请求人脸识别的token参数：{}", JSONObject.toJSONString(params));
		
		Map<String, Object> value = systemConfigUtils.getValue("GD_FACE_DEAL_URL");
		String resUrl = (String)value.get("gd_face_deal_result");
		
		String rspJson = HttpUtil.sendPostWithJson(resUrl, params);
		
		logger.info("获取h5请求人脸识别的token返回信息：{}",rspJson);
		return (Map<String, Object>) JSONObject.parseObject(rspJson);
	}

	/**
	 *  @author: liyong
	 *  @Date: 2020-03-08 下午 12:17
	 *  @Description: 获取微信公众号关注用户的信息
	 */
	public JSONObject getMpUserInfo(String wxCode) {
        Map<String, Object> value = systemConfigUtils.getValue("GD_FACE_DEAL_URL");
        String resUrl = (String) value.get("gd_face_deal_weixingzh");
        Map<String, Object> params = new HashMap<>(8);
        params.put("wxCode", wxCode);
        logger.info("获取微信公众号关注用户的信息参数：{}", JSONObject.toJSONString(params));
        String rspJson = HttpUtil.sendPostWithJson(resUrl, params);
        logger.info("微信公众号关注用户的信息返回信息：{}", rspJson);
        JSONObject jsonObject = JSONObject.parseObject(rspJson);
        if (0 == jsonObject.getInteger("code")) {
            return jsonObject;
        } else {
            throw new BusinessException(AgentResponseCode.INVALID_WECHAT_CODE);
        }

    }
}
