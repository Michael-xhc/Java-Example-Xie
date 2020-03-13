/**
 * 
 */
package cn.com.sinosafe.xiecommon.commonService;

import cn.com.sinosafe.xiecommon.code.AgentResponseCode;
import cn.com.sinosafe.xiecommon.exception.BusinessException;
import cn.com.sinosafe.xiecommon.utils.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**  
* <p>Title: agentRegisterService</p>  
* <p>Description: </p>  
* @author longxiaoqiang  
* @date 2020年2月17日  
*/
@Component
public class AgentRegisterSignService {

	private static final Logger logger = LoggerFactory.getLogger(AgentRegisterSignService.class);
	 /**
     * 安心签开户,已开过户则直接返回
     * 
     * @param reqMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public String register(String reqUrl, Map<String, Object> registerReqMap) throws Exception {
        // 请求开户
        long beginTime = System.currentTimeMillis();
        logger.info("安心签开户，请求参数为registerReqMap={}", JSONObject.toJSONString(registerReqMap));
        String retInfo = HttpUtil.sendPost(reqUrl, registerReqMap);
        long endTime = System.currentTimeMillis();
        logger.info("安心签开户请求完成，返回参数为retInfo={} ，请求耗时:[{}]毫秒.", retInfo, endTime - beginTime);

        // 处理返回结果
        Map<String, Object> retMap = (Map<String, Object>) JSONObject.parse(retInfo);
        Map<String, Object> dataMap = (Map<String, Object>)retMap.get("data");
        if ((int)retMap.get("code") == 1 && isReturnOk(dataMap)) {
            Map<String, Object> personMap = (Map<String, Object>)dataMap.get("person");
            // 开户成功 返回用户ID
            return personMap.get("userId").toString();
        } else {
            logger.error("安心签开户失败,errorCode={}, errorMessage={}", dataMap.get("errorCode".toString()),
                dataMap.get("errorMessage".toString()));
            throw new BusinessException(AgentResponseCode.CREDIT_REGISTER_ERROR);
        }
    }
    
    /**
     * 返回结果校验
     * 
     * @param dataMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    private boolean isReturnOk(Map<String, Object> dataMap) throws Exception {
        Map<String, Object> headMap = (Map<String, Object>)dataMap.get("head");
        if (headMap != null && headMap.get("retCode").equals("60000000")) {
            return true;
        }
        return false;
    }
    /**
     * 安心签发送短信验证码
     * 
     * @param reqUrl
     * @param msgReqMap
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void sendCreditMsg(String reqUrl, Map<String, Object> msgReqMap) throws Exception {
        // 请求发送短信
        long beginTime = System.currentTimeMillis();
        logger.info("安心签发送短信验证码，请求参数为msgReqMap={}", JSONObject.toJSONString(msgReqMap));
        String retInfo = HttpUtil.sendPost(reqUrl, msgReqMap);
        long endTime = System.currentTimeMillis();
        logger.info("安心签发送短信验证码请求完成，返回参数为retInfo={} ，请求耗时:[{}]毫秒.", retInfo, endTime - beginTime);

        // 处理返回结果
        Map<String, Object> retMap = (Map<String, Object>) JSONObject.parse(retInfo);
        Map<String, Object> dataMap = (Map<String, Object>)retMap.get("data");
        if ((int)retMap.get("code") == 1 && isReturnOk(dataMap)) {
            // 短信发送成功
        	logger.info("征信签署短信发送成功.");
        } else {
            // 短息发送失败
        	logger.error("安心签发送短信验证码失败,errorCode={}, errorMessage={}", dataMap.get("errorCode".toString()),
                dataMap.get("errorMessage".toString()));
            throw new BusinessException(AgentResponseCode.CREDIT_SEND_MSG_ERROR);
        }
    }
    /**
     * 校验签署验证码
     * 
     * @param dicConfigByKey
     * @param verifyReqMap
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void verifyMsg(String reqUrl, Map<String, Object> verifyReqMap) throws Exception {
        // 授权码验证请求
        long beginTime = System.currentTimeMillis();
        logger.info("征信签署短信验证，请求参数为msgReqMap={}", JSONObject.toJSONString(verifyReqMap));
        String retInfo = HttpUtil.sendPost(reqUrl, verifyReqMap);
        long endTime = System.currentTimeMillis();
        logger.info("征信签署短信验证请求完成，返回参数为retInfo={} ，请求耗时:[{}]毫秒.", retInfo, endTime - beginTime);

        // 处理返回结果
        Map<String, Object> retMap = (Map<String, Object>) JSONObject.parse(retInfo);
        Map<String, Object> dataMap = (Map<String, Object>)retMap.get("data");
        if ((int)retMap.get("code") == 1 && isReturnOk(dataMap)) {
            // 短信校验通过
        	logger.info("征信签署短信校验通过.");
        } else {
            // 授权码验证失败
        	logger.error("征信签署短信验证失败,errorCode={}, errorMessage={}", dataMap.get("errorCode".toString()),
                dataMap.get("errorMessage".toString()));
            throw new BusinessException(AgentResponseCode.CREDIT_VERIFY_MSGCODE_ERROR);
        }
    }
    /**
     * 创建合同对象并签署印章
     * 
     * @param reqMap
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public String createConAndsignature(String reqUrl, com.alibaba.fastjson.JSONObject reqMap) throws Exception {
        // 请求创建合同对象并签署印章
        long beginTime = System.currentTimeMillis();
        logger.info("创建合同对象并签署印章，请求参数为msgReqMap={}", JSONObject.toJSONString(reqMap));
        String retInfo = HttpUtil.sendPost(reqUrl, reqMap);
        long endTime = System.currentTimeMillis();
        logger.info("创建合同对象并签署印章请求完成，返回参数为retInfo={} ，请求耗时:[{}]毫秒.", retInfo, endTime - beginTime);

        // 处理返回结果
        Map<String, Object> retMap = (Map<String, Object>) JSONObject.parse(retInfo);
        Map<String, Object> dataMap = (Map<String, Object>)retMap.get("data");
        if ((int)retMap.get("code") == 1 && isReturnOk(dataMap)) {
            // 创建合同对象并签署印章成功
            return ((Map<String, Object>)dataMap.get("contract")).get("contractNo").toString();
        } else {
            // 创建合同对象并签署印章失败
        	logger.error("创建合同对象并签署印章失败,errorCode={}, errorMessage={}", dataMap.get("errorCode".toString()),
                dataMap.get("errorMessage".toString()));
            throw new BusinessException(AgentResponseCode.CREDIT_CONTRACT_SIGN_ERROR);
        }
    }
    /**
     * 下载签署合同并上传到影像系统
     * 
     * @param uploadUrl
     * @param uploadMap
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> uploadContract(String uploadUrl, Map<String, Object> uploadMap) throws Exception {
        // 下载签署合同并上传到影像系统请求
        long beginTime = System.currentTimeMillis();
        logger.info("下载签署合同并上传到影像系统，请求参数为msgReqMap={}", JSONObject.toJSONString(uploadMap));
        String retInfo = HttpUtil.sendPost(uploadUrl, uploadMap);
        long endTime = System.currentTimeMillis();
        logger.info("下载签署合同并上传到影像系统请求完成，返回参数为retInfo={} ，请求耗时:[{}]毫秒.", retInfo, endTime - beginTime);

        // 处理返回结果
        Map<String, Object> retMap = (Map<String, Object>) JSONObject.parse(retInfo);
        Map<String, Object> dataMap = (Map<String, Object>)retMap.get("data");
        if ((int)retMap.get("code") != 1 && isReturnOk(dataMap)) {
        	logger.error("下载签署合同并上传到影像系统失败,errorCode={}, errorMessage={}", dataMap.get("errorCode".toString()),
                dataMap.get("errorMessage".toString()));
            throw new BusinessException(AgentResponseCode.CREDIT_CONTRACT_UPLOAD_ERROR);
        }

        return dataMap;
    }
}
