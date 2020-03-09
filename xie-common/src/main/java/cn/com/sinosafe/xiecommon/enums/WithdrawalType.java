package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 资金账户明细类型枚举
* @Author  : HuYang
* @Date    : 2020年2月22日 下午1:18:00
* @Version : 1.0
 */
public enum WithdrawalType {
	
	AGENT_COMMISION(1, "佣金"),
	RED_PACKET(2, "红包"),
	INVITER_COMMISION(3, "邀请人佣金");
	
	private int code;
	private String desc;
	
	private WithdrawalType() {
	}
	
	private WithdrawalType(int code, String desc) {
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
