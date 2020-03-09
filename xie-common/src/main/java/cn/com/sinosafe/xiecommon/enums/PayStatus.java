package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 手续费支付状态枚举
* @Author  : HuYang
* @Date    : 2020年2月25日 下午3:33:35
* @Version : 1.0
 */
public enum PayStatus {
	
	INIT(1, "待支付"),
	PAYING(2, "支付中"),
	SUCCESS(3, "支付成功"),
	FAIL(4, "支付失败");
	
	private int code;
	private String desc;
	
	private PayStatus() {
	}
	
	private PayStatus(int code, String desc) {
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
