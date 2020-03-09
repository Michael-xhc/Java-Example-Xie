package cn.com.sinosafe.xiecommon.enums;

/**   
 * @ClassName:  LoginType   
 * @Description:登录类型枚举   
 * @author: HuYang
 * @date:   2020年2月11日 下午4:31:00      
 * @Copyright:  
 */
public enum LoginType {
	
	LOGIN_TYPE_PHONE(1, "验证码登录"),
	LOGIN_TYPE_ACCOUNT(2, "账号密码登录"),
	LOGIN_TYPE_WECHAT(3, "微信登录"),
	LOGIN_TYPE_OUT(4, "退出登录"),
	LOGIN_TYPE_AUTO(5, "注册完成自动登录");
	
	private int code;
	private String desc;
	
	private LoginType() {
	}
	
	private LoginType(int code, String desc) {
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
