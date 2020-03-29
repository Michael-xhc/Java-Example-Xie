/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xiecommon.exception
 * fileName: BusinessException.java
 * date: 2020-03-27 15:58
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xiecommon.exception;

import cn.com.sinosafe.xiecommon.code.ResultCode;

/**
 * @description: 自定义异常
 * @packageName: cn.com.sinosafe.xiecommon.exception
 * @className: BusinessException
 * @author: xiehanchun
 * @data: 2020-03-27 15:58
 * @version: v1.0
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected final String message;
    private int code;

    public BusinessException(String message) {
        this.message = message;
    }

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

    public void setCode(int code) {
        this.code = code;
    }

}
