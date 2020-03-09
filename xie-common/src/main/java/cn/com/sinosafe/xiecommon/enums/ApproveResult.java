package cn.com.sinosafe.xiecommon.enums;

/**
 * @PACKAGE_NAME: cn.com.sinosafe.agent.common.enums
 * @NAME: ApproveResult
 * @description: ${description}
 * @USER: xiehanchun
 * @time: 2020/2/26 18:12
 * @Version 1.0
 **/
public enum ApproveResult {

    /**
     * 审批结果
     */
    APPLYING(1,"进行中"),VETO(2,"否决"),ADOPT(3,"通过"),END(4,"结束");

    private final int code;
    private final String msg;

    private ApproveResult(int code,String msg){
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
