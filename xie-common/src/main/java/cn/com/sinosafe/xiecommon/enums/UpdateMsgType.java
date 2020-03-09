package cn.com.sinosafe.xiecommon.enums;

/**
 * @ClassName:  UpdateMsgType   
 * @Description:绑定手机号修改验证码类型枚举   
 * @author: HuYang
 * @date:   2020年2月17日 上午10:11:25      
 * @Copyright:
 */
public enum UpdateMsgType {
	
	ORIGIN_UPDATE_MSG(1, "发送验证码到原始手机"),
	NEW_UPDATE_MSG(2, "发送验证码到新手机");
	
	private int code;
	private String desc;
	
	private UpdateMsgType() {
	}
	
	private UpdateMsgType(int code, String desc) {
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
