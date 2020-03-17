/**
 * All rights Reserved, Designed By www.sinosafe.com.cn
 * @Title:  WebcontrollerAop.java
 * @Package cn.com.sinosafe.haFin.api.controller
 * @Description:    描述
 * @author: HuYang
 * @date:   2020年1月16日 上午11:49:58
 * @version V1.0
 * @Copyright:
 */
package cn.com.sinosafe.xieapi.aop;

import com.alibaba.fastjson.JSONObject;
import org.apache.catalina.core.ApplicationPart;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * @ClassName:  WebcontrollerAop
 * @Description:输入输出参数打印
 * @author: HuYang
 * @date:   2020年1月16日 上午11:49:58
 * @Copyright:
 */
@Aspect
@Component
public class WebcontrollerAop {

	private static final Logger logger = LoggerFactory.getLogger(WebcontrollerAop.class);

	/**
     * 指定切点
     * 匹配 cn.com.sinosafe.haFin.api.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(* cn.com.sinosafe.xieapi..*.*(..))")
    public void  optlog(){
    }

    /**
     * 前置通知，方法调用前被调用
     * @param joinPoint
     */
    @Before("optlog()")
    public void doBefore(JoinPoint joinPoint){

    }

    /**
     * 处理完请求返回内容
     * @param ret
     * @throws Throwable
     */

    @AfterReturning(returning = "ret", pointcut = "optlog()")
    public void doAfterReturning(Object ret) throws Throwable {

    }

    /**
     * 后置异常通知
     * @param jp
     */

    @AfterThrowing("optlog()")
    public void throwss(JoinPoint jp){

    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param jp
     */
    @After("optlog()")
    public void after(JoinPoint jp){

    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     * @param pjp
     * @return
     */

    @Around("optlog()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable{
    	Object result = null;
    	long start = System.currentTimeMillis();
		try {
			String className = pjp.getTarget().getClass().getName();
			String methodName = pjp.getSignature().getName();
			// 获取request对象
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			// 请求地址
			String reqUrl = request.getRequestURL().toString();
			// 请求方式
			String method = request.getMethod();
			// 获取query参数
			String queryString = request.getQueryString();
			// 获取请求参数集合并进行遍历拼接
			JSONObject reqParams = getReqParams(pjp, method, queryString);
			JSONObject reqJson = new JSONObject();
			reqJson.put("请求方法", className+"@"+methodName);
			reqJson.put("请求链接", reqUrl);
			reqJson.put("请求类型", method);
			reqJson.put("请求参数", reqParams);
//			logger.info("【请求日志拦截】拦截信息:{}", JSONUtils.getSingleInstance().responseFormat(reqJson.toJSONString()));
		} catch (Exception e) {
			logger.info("【请求日志拦截】拦截信息:{}", "获取请求参数信息失败!");
			throw e;
		}finally {
			result = pjp.proceed();
			JSONObject rspJson = new JSONObject();
			rspJson.put("请求耗时", (System.currentTimeMillis() - start)+"毫秒");
			rspJson.put("返回结果", JSONObject.toJSONString(result));
//			logger.info("【响应日志拦截】拦截信息:{}", JSONUtils.getSingleInstance().responseFormat(rspJson.toString()));
		}
        return result;

    }

    private JSONObject getReqParams(ProceedingJoinPoint pjp, String method, String queryString) throws Exception {
        JSONObject reqParams = new JSONObject();
        Object[] args = pjp.getArgs();
        if (args!=null&&args.length > 0) {
            if ("POST".equalsIgnoreCase(method)) {
                Object object = args[0];
                if(object!=null && object instanceof JSONObject){
                	return (JSONObject) object;
                }
                reqParams = getKeyAndValue(object);
            } else if ("GET".equalsIgnoreCase(method)) {
                reqParams.put("reqParams", queryString);
            }
        }
        return reqParams;
    }

    /**
     * 反射获取POST请求参数
     *
     * @param obj
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static JSONObject getKeyAndValue(Object obj) {
        JSONObject paraJson = new JSONObject();
        // 得到类对象
        Class userCla = (Class)obj.getClass();
        // 得到类中的所有属性集合
        Field[] fs = userCla.getFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            // 设置些属性是可以访问的
            f.setAccessible(true);
            Object val = new Object();
            try {
                val = f.get(obj);
                // 排除空值和文件
                if (val != null && !(val instanceof ApplicationPart)) {
                	paraJson.put(f.getName(), val);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return paraJson;
    }
}
