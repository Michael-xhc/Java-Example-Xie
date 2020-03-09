package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 外部接口调用状态枚举
* @Author  : HuYang
* @Date    : 2020年2月24日 下午3:49:27
* @Version : 1.0
 */
public enum OutLogStatus {
	
	SUCCESS(1, "请求完成"),
	EXCEPTION(2, "请求异常");
	
	private int code;
	private String desc;
	
	private OutLogStatus() {
	}
	
	private OutLogStatus(int code, String desc) {
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
