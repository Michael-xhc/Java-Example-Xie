package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 邀请人类型枚举类
* @Author  : HuYang
* @Date    : 2020年2月25日 下午8:21:06
* @Version : 1.0
 */
public enum InviterType {
	
	INNER(1, "内部员工"),
	AGENT(2, "代理人");
	
	private int code;
	private String desc;
	
	private InviterType() {
	}
	
	private InviterType(int code, String desc) {
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
