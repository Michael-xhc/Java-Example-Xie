/**
 * 
 *//*

package cn.com.sinosafe.xiecommon.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

*/
/**
* <p>Title: SystemConfigUtils</p>  
* <p>Description: 查询字典工具类</p>  
* @author longxiaoqiang  
* @date 2020年2月13日  
*//*

@Component
public class SystemConfigUtils {
	
	Logger logger = LoggerFactory.getLogger(SystemConfigUtils.class);
	
	@Reference(timeout = 60000, retries = 0, url = "dubbo://10.2.108.91:30999")
    private CopAppApplyService copAppApplyService;
	@Resource
	private RedisUtils redisUtils;
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getValue(String dicType) {
		
		try {
			logger.info("查询的字典的l类型={}",dicType);
			
			Object msgCode = null;//redisUtils.getValue(AgentConstants.SYSTEM_CONFIG_REDIS_KEY.concat(dicType));
			if(msgCode==null){
				
				//缓存为空调用接口查询
				Map<String, Object> map = new HashMap<>();
				map.put("dicType", dicType);
				String questData = JSONUtils.getSingleInstance().toJSon(map);
				String rspInfo = copAppApplyService.queryCopAppDic(questData);
				
				//解析返回结果
				if (StringUtils.isNotEmpty(rspInfo)) {
	                Map<String, Object> rspMap = (Map<String, Object>) JSONObject.parse(rspInfo);
	                String returnCode = rspMap.get("returnCode").toString();
	                Map<String, Object> dataMap = (Map<String, Object>)rspMap.get("data");
	                if ("0000".equals(returnCode)) {
	                	
	                	//存入缓存，设置有效时间为30天
	                	redisUtils.setValue(AgentConstants.SYSTEM_CONFIG_REDIS_KEY.concat(dicType), dataMap, AgentConstants.SYSTEM_CONFIG_EXPIRE_TIME);
	                    return dataMap;
	                }
	            }
			}else {
				return (Map<String, Object>)msgCode;
			}
		} catch (Exception e) {
			logger.error("根据字典类型="+dicType+"获取字典失败",e);
		}
		return null;
	}
}
*/
