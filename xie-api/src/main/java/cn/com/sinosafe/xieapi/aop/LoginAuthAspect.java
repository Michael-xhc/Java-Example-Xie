package cn.com.sinosafe.xieapi.aop;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName:  LoginAuthAspect   
 * @Description:登录鉴权切面  
 * @author: HuYang
 * @date:   2020年2月12日 上午10:46:22      
 * @Copyright:
 */
@Aspect
@Component
public class LoginAuthAspect{

    private final static Logger logger = LoggerFactory.getLogger(LoginAuthAspect.class);

    @Resource
	private RedisUtils redisUtils;

    @Before(value = "@annotation(cn.com.sinosafe.xiecommon.annotation.Authentication)")
    public void doBefore(JoinPoint joinPoint) throws Exception {
    	ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
        // 获取登录accessToken
        String accessToken = request.getHeader("accessToken");
        //从redis获取用户信息
        Object userInfo = redisUtils.getValue(accessToken);
        // 获取登录用户
        if (StringUtils.isBlank(accessToken) || userInfo == null) {
            logger.info("【登录拦截器】您的账号缓存已过期,请重新登录");
            throw new BusinessException(AgentResponseCode.LOGIN_SESSION_EXPIRED);
        }
        //判断用户状态
        JSONObject redisValue = JSONObject.parseObject(userInfo.toString());
//		UserBaseInfo userBaseInfo = JSONObject.parseObject(redisValue.getString("userBaseInfo"), UserBaseInfo.class);
//        if(userBaseInfo.getUserStatus()== UserStatus.LOGIN_TYPE_FREEZE.getCode()){
//        	logger.info("【登录拦截器】您的账号被冻结,请联系管理员处理.");
//        	throw new BusinessException(AgentResponseCode.USER_FREEZE);
//        }
//        if(userBaseInfo.getUserStatus()==UserStatus.LOGIN_TYPE_KICK.getCode()){
//        	logger.info("【登录拦截器】您的账号已被永久封号,无法登录.");
//        	throw new BusinessException(AgentResponseCode.KICK_FREEZE);
//        }
//		logger.info("【登录拦截器】登录验证通过.phone={}, userId= {}", userBaseInfo.getPhoneNumber(), userBaseInfo.getUserId());
    }
}
