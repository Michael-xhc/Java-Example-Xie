package cn.com.sinosafe.xiecommon.enums;


/**
 * @PACKAGE_NAME: cn.com.sinosafe.agent.common.enums
 * @NAME: ConferType
 * @description: ${description}
 * @USER: xiehanchun
 * @time: 2020/2/26 17:18
 * @Version 1.0
 **/
public enum ConferType {
    /**
     * 协议类型
     */
    CONF_SUPP(1,"补充协议"), CONF_TOTAL(2,"全量协议 ");

    private final int code;
    private final String msg;

    private ConferType(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}
