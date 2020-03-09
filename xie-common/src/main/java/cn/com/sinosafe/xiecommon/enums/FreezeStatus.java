package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 佣金及奖励冻结状态枚举类
* @Author  : HuYang
* @Date    : 2020年2月22日 下午4:30:24
* @Version : 1.0
*/
public enum FreezeStatus {
	
	NORMAL(2, "正常"),
	FREEZE(1, "冻结");
	
	private int code;
	private String desc;
	
	private FreezeStatus() {
	}
	
	private FreezeStatus(int code, String desc) {
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
