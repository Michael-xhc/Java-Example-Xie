package cn.com.sinosafe.xiecommon.enums;

/**   
 * @ClassName:  LoginType   
 * @Description:用户账户状态枚举   
 * @author: HuYang
 * @date:   2020年2月11日 下午4:31:00      
 * @Copyright:  
 */
public enum AccountStatus {
	
	NORMAL(1, "正常"),
	INVALID(2, "无效");
	
	private int code;
	private String desc;
	
	private AccountStatus() {
	}
	
	private AccountStatus(int code, String desc) {
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
