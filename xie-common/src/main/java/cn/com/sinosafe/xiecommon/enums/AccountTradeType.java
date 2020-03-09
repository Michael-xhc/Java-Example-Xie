package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 资金交易流水类型枚举
* @Author  : HuYang
* @Date    : 2020年2月22日 下午1:18:00
* @Version : 1.0
 */
public enum AccountTradeType {
	
	WITHDRAW(1, "提现"),
	FREEZE(2, "冻结"),
	TRANSFER_IN(3, "转入");
	
	private int code;
	private String desc;
	
	private AccountTradeType() {
	}
	
	private AccountTradeType(int code, String desc) {
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
