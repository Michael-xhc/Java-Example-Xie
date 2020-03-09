package cn.com.sinosafe.xiecommon.enums;

/**
 * 好伙伴业务状态
 * 
 * @author huyang
 *
 */
public enum ImgPathInfo {
    
    PATH_1("身份证", "SFZZM");

    private final String msg;
    private final String code;

    private ImgPathInfo(String msg, String code) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
