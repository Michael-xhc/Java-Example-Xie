package cn.com.sinosafe.xiecommon.exception;

import cn.com.sinosafe.xiecommon.code.ResultCode;
/**
 * @ClassName:  BusinessException   
 * @Description:自定义业务异常   
 * @author: HuYang
 * @date:   2020年2月11日 下午4:13:33      
 * @Copyright:
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected final String message;
    private int code;

//    public BusinessException(ResultCode message) {
//        this.message = message;
//    }

    public BusinessException(ResultCode resultCode) {
        this.message = resultCode.getMessage();
        this.code = resultCode.getCode();
    }
    
    public BusinessException(ResultCode resultCode, boolean format, String field) {
    	if(format){
    		this.message = String.format(resultCode.getMessage(), field);
    	}else{
    		this.message = resultCode.getMessage();
    	}
    	this.code = resultCode.getCode();
    }

    public BusinessException(int code, String desc) {
        this.message = desc;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
