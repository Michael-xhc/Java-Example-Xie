package cn.com.sinosafe.xiecommon.enums;

/**   
 * @ClassName:  LoginType   
 * @Description:登录类型枚举   
 * @author: HuYang
 * @date:   2020年2月11日 下午4:31:00      
 * @Copyright:  
 */
public enum UserStatus {
	
	LOGIN_TYPE_NORMAL(1, "正常"),
	LOGIN_TYPE_APPLY(2, "代理申请审核"),
	LOGIN_TYPE_FREEZE(3, "冻结"),
	LOGIN_TYPE_KICK(4, "永久封号");
	
	private int code;
	private String desc;
	
	private UserStatus() {
	}
	
	private UserStatus(int code, String desc) {
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
