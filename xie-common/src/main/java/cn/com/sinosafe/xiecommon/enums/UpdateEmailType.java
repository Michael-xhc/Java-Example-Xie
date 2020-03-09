package cn.com.sinosafe.xiecommon.enums;

/**
 * @ClassName:  UpdateMsgType   
 * @Description:绑定邮箱修改验证码类型枚举   
 * @author: HuYang
 * @date:   2020年2月17日 上午10:11:25      
 * @Copyright:
 */
public enum UpdateEmailType {
	
	ORIGIN_UPDATE_EMAIL(1, "发送验证码到原始邮箱"),
	NEW_UPDATE_EMAIL(2, "发送验证码到新邮箱");
	
	private int code;
	private String desc;
	
	private UpdateEmailType() {
	}
	
	private UpdateEmailType(int code, String desc) {
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
