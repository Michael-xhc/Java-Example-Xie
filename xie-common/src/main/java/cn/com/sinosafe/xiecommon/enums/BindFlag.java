package cn.com.sinosafe.xiecommon.enums;

/**
 * @PACKAGE_NAME: cn.com.sinosafe.agent.common.enums
 * @NAME: BindFlag
 * @description: ${description}
 * @USER: xiehanchun
 * @time: 2020/2/26 18:04
 * @Version 1.0
 **/
public enum BindFlag {
    /**
     * 销管绑定标志
     */
    BIND_FLAG_YES(1,"绑定销管"),BIND_FLAG_NO(2,"未绑定销管"),
    /**
     * 卡号状态
     */
    STATUS_Y(1,"有效"),STATUS_N(2,"无效");

    private final int code;
    private final String msg;

    private BindFlag(int code,String msg){
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
