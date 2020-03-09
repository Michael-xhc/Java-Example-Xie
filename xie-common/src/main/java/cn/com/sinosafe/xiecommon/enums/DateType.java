package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 榜单排行统计范围类型枚举
* @Author  : HuYang
* @Date    : 2020年2月18日 下午5:24:01
* @Version : 1.0
 */
public enum DateType {
	/**
	 * 当日
	 */
	DAY(1, "当日"),
	/**
	 * 当月
	 */
	MONTH(2, "当月"),
	/**
	 * 当季度
	 */
	QUARTER(3, "当季度"),
	/**
	 * 半年
	 */
	HALF_YEAR(4, "半年"),
	/**
	 * 当年
	 */
	YEAR(5, "当年"),
	/**
	 * 所有
	 */
	ALL(6, "所有");
	
	private int code;
	private String desc;
	
	private DateType() {
	}
	
	private DateType(int code, String desc) {
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
