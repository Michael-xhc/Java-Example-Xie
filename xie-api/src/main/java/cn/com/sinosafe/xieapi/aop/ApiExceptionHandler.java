package cn.com.sinosafe.xieapi.aop;

import cn.com.sinosafe.xiecommon.exception.BusinessException;
import cn.com.sinosafe.xiecommon.utils.AgentJsonProtocol;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 
 * @ClassName:  ApiExceptionHandler   
 * @Description:异常统一处理拦截   
 * @author: xiehanchun
 * @date:   2020年2月11日 下午7:56:09      
 * @Copyright:
 */

@RestControllerAdvice
@ResponseBody
public class ApiExceptionHandler {

    Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    /**
     * 拦截业务异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public AgentJsonProtocol handleBusinessException(BusinessException be) {

        // 推送异常邮件

        // 返回结果
        AgentJsonProtocol rspObj = new AgentJsonProtocol();
        rspObj.setCode(be.getCode());
        rspObj.setMessage(be.getMessage());
//        be.printStackTrace();

        logger.error("【个代请求异常】msg={}", ExceptionUtils.getStackTrace(be));

        return rspObj;
    }

    /**
     * 其它异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public AgentJsonProtocol hadleServerException(Exception exception) {
        // 推送异常邮件
        logger.error("【个代请求异常】msg={}", ExceptionUtils.getStackTrace(exception));
        // 返回结果
        exception.printStackTrace();
        return AgentJsonProtocol.fail();
    }
}
