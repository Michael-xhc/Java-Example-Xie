package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 外部请求日志类型枚举
* @Author  : HuYang
* @Date    : 2020年2月24日 下午3:44:26
* @Version : 1.0
 */
public enum OutLogType {
	
	QUERY_AGENT(1, "销管代理人查询"),
	ADD_AGENT(2, "销管代理人新增"),
	UPDATE_AGENT(3, "销管代理人更新"),
	ASYNC_CONTRACT_STATUS(4, "销管系统回调同步合同申请状态"),
	QUERY_TAX(5, "销管系统回调同步合同申请状态"),
	SUBMIT_WITHDRAWAL(6, "对接费管结算申请接口"),
	SIGN_CONTRACT(7, "对接申请签署合同接口"),
	CORRECT_COMMISION(8, "佣金批改");
	
	private int code;
	private String desc;
	
	private OutLogType() {
	}
	
	private OutLogType(int code, String desc) {
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
