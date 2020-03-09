package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 佣金结算状态枚举
* @Author  : HuYang
* @Date    : 2020年2月20日 下午9:22:26
* @Version : 1.0
 */
public enum SettleStatus {
	
	UN_SETTLE(1, "未结算"),
	DEPT_SETTLE(2, "部分结算"),
	FINISH_SETTLE(3, "结算完成");
	
	private int code;
	private String desc;
	
	private SettleStatus() {
	}
	
	private SettleStatus(int code, String desc) {
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
