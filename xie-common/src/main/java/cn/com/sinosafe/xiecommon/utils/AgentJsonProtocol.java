/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xiecommon.utils
 * fileName: AgentJsonProtocol.java
 * date: 2020-03-29 12:10
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xiecommon.utils;

import cn.com.sinosafe.xiecommon.code.AgentResponseCode;
import cn.com.sinosafe.xiecommon.code.ResultCode;

/**
 * @description: 公共返回参数
 * @packageName: cn.com.sinosafe.xiecommon.utils
 * @className: AgentJsonProtocol
 * @author: xiehanchun
 * @data: 2020-03-29 12:10 分担
 * @version: v1.0
 */
public class AgentJsonProtocol {
    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public AgentJsonProtocol() {
    }

    public AgentJsonProtocol(int cde, String msg) {
        this.code = cde;
        this.message = msg;
    }

    public AgentJsonProtocol(int cde,  String msg, Object data) {
        this.code = cde;
        this.message = msg;
        this.data = data;
    }

    public AgentJsonProtocol(int cde, Object data) {
        this.code = cde;
        this.data = data;
    }

    public static AgentJsonProtocol setup(ResultCode resultCode) {
        return new AgentJsonProtocol(resultCode.getCode(), resultCode.getMessage());
    }

    public static AgentJsonProtocol setup(ResultCode resultCode, Object data) {
        return new AgentJsonProtocol(resultCode.getCode(), resultCode.getMessage(),data);
    }

    public static AgentJsonProtocol setup(int result, Object data) {
        return new AgentJsonProtocol(result, data);
    }

    public static AgentJsonProtocol setupAsException(Throwable e) {
        return new AgentJsonProtocol(ResultCode.SERVER_ERROR.getCode(), e.getMessage());
    }

    public static AgentJsonProtocol setup(int cde, String msg) {
        return new AgentJsonProtocol(cde, msg);
    }

    public static AgentJsonProtocol success() {
        return AgentJsonProtocol.setup(AgentResponseCode.SUCCESS);
    }

    public static AgentJsonProtocol fail() {
        return AgentJsonProtocol.setup(AgentResponseCode.FAIL);
    }

    public static AgentJsonProtocol failJson(String msg) {
        return AgentJsonProtocol.setup(AgentResponseCode.FAIL.getCode(),msg);
    }

    public static AgentJsonProtocol response(Object obj) {
        return AgentJsonProtocol.setup(AgentResponseCode.SUCCESS,obj);
    }

    public long getTimestamp() {
        return System.currentTimeMillis();
    }
}
