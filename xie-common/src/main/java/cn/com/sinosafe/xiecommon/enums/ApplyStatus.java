package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 申请状态枚举
* @Author  : HuYang
* @Date    : 2020年2月20日 下午9:33:44
* @Version : 1.0
 */
public enum ApplyStatus {
	
	APPLY_S2(2,"代理人"),APPLY_S3(3,"立即申请成为信代专家（个人代理人）"),
	APPLY_S4(4,"申请资料审核中，预计需要1-7个工作日"),APPLY_S5(5,"审核失败，点击查看原因"),
	APPLY_S6(6,"资料已通过初审，立即签约代理协议"),
	APPLYING(1, "申请中"),APPLY_FAIL(8,"申请失败");
	
	private int code;
	private String desc;
	
	private ApplyStatus() {
	}
	
	private ApplyStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	// 根据desc获取枚举
    public static String getContent(int code){
        for(ApplyStatus temp:ApplyStatus.values()){
            if(temp.getCode() == code){
                return temp.getDesc();
            }
        }
        return null;
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
