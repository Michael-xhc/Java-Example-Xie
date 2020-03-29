/**
 * projectName: Haxb-Outsource-Xie
 * packageName: cn.com.sinosafe.xiecommon.utils
 * fileName: AgentResponseCode.java
 * date: 2020-03-29 12:22
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xiecommon.code;

/**
 * @description: 自定义异常业务编码
 * @packageName: cn.com.sinosafe.xiecommon.utils
 * @className: AgentResponseCode
 * @author: xiehanchun
 * @data: 2020-03-29 12:22
 * @version: v1.0
 */
public class AgentResponseCode extends ResultCode{
    // protected 在同类 同包下都可以调用
    protected AgentResponseCode(int code, String message) {
        super(code, message);
    }

    public static final ResultCode EXCEPTION_FORMAT = new ResultCode(99999, "%s");
    public static final ResultCode NULL_PARAM = new ResultCode(1000000, "参数[%s]不能为空");
    public static final ResultCode ERROR_PASSWORD = new ResultCode(1000001, "账号不存在或密码不正确!");
    public static final ResultCode ERROR_LOGIN_TYPE = new ResultCode(1000002, "不支持的登录类型");
    public static final ResultCode NULL_USER = new ResultCode(1000003, "账号不存在!");
    public static final ResultCode UN_LOGIN_USER = new ResultCode(1000004, "账号不可用!");
}
