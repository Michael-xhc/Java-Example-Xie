package cn.com.sinosafe.xiecommon.enums;

/**
 * @PACKAGE_NAME: cn.com.sinosafe.agent.common.enums
 * @NAME: ExistAgent
 * @description: ${description}
 * @USER: xiehanchun
 * @time: 2020/2/26 17:18
 * @Version 1.0
 **/
public enum ExistAgent {
    /**
     * 申请时是否为公司代理人
     */
    AGENT_YES(1,"是"),AGENT_NO(2,"否");

    private final String msg;
    private final int code;

    private ExistAgent(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

}
