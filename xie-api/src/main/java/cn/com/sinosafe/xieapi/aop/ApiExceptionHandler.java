/*
package cn.com.sinosafe.xieapi.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

*/
/**
 * 
 * @ClassName:  ApiExceptionHandler   
 * @Description:异常统一处理拦截   
 * @author: HuYang
 * @date:   2020年2月11日 下午7:56:09      
 * @Copyright:
 *//*

@RestControllerAdvice
@ResponseBody
public class ApiExceptionHandler {

    */
/**
     * 拦截业务异常
     * 
     * @param exception
     * @return
     *//*

    @ExceptionHandler(BusinessException.class)
    public AgentJsonProtocol handleBusinessException(BusinessException be) {

        // 推送异常邮件

        // 返回结果
    	AgentJsonProtocol rspObj = new AgentJsonProtocol();
        rspObj.setCode(be.getCode());
        rspObj.setMessage(be.getMessage());
        be.printStackTrace();

        return rspObj;
    }

    */
/**
     * 其它异常
     * 
     * @param exception
     * @return
     *//*

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public AgentJsonProtocol hadleServerException(Exception exception) {
        // 推送异常邮件

        // 返回结果
    	exception.printStackTrace();
        return AgentJsonProtocol.fail();
    }
}
*/
