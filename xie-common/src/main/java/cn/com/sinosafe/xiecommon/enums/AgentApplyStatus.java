package cn.com.sinosafe.xiecommon.enums;

/**
 * @ClassName:  ApplyStatus
 * @Description:申请状态枚举
 * @author: liyong
 * @date:   2020年2月24日 下午3:14
 * @Copyright:
 */
public enum  AgentApplyStatus {

    AGENT_APPLY_STATUS1(1, "申请中"),
    AGENT_APPLY_STATUS2(2, "自动审批中"),
    AGENT_APPLY_STATUS3(3, "人工审批中"),
    AGENT_APPLY_STATUS4(4, "合同审批中"),
    AGENT_APPLY_STATUS5(5, "合同签署中"),
    AGENT_APPLY_STATUS6(6, "信息报备中"),
    AGENT_APPLY_STATUS7(7, "申请成功"),
    AGENT_APPLY_STATUS8(8, "申请失败"),
    AGENT_APPLY_STATUS9(9, "申请超时失效");
	
    private int code;
    private String desc;

    private AgentApplyStatus() {
    }

    private AgentApplyStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
