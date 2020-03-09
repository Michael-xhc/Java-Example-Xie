package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 资金账户流水交易状态枚举
* @Author  : HuYang
* @Date    : 2020年2月22日 下午1:18:00
* @Version : 1.0
 */
public enum AccountTradeStatus {
	
	SUCCESS(1, "成功"),
	FAIL(2, "失败");
	
	private int code;
	private String desc;
	
	private AccountTradeStatus() {
	}
	
	private AccountTradeStatus(int code, String desc) {
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
