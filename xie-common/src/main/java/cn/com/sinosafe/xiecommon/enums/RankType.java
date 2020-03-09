package cn.com.sinosafe.xiecommon.enums;

/**
* @Project : agent-common
* @Desc    : 榜单排行种类枚举
* @Author  : HuYang
* @Date    : 2020年2月18日 下午5:24:01
* @Version : 1.0
 */
public enum RankType {
	/**
	 * 保费收入榜
	 */
	PREMIUM(1, "保费收入榜"),
	/**
	 * 放款金额榜
	 */
	LOAN(2, "放款金额榜"),
	/**
	 * 推荐笔数榜
	 */
	RECOMMEND(3, "推荐笔数榜"),
	/**
	 * 预审通过榜
	 */
	APPROVE(4, "预审通过榜"),
	/**
	 * 邀请好友奖励榜
	 */
	REWARD(5, "邀请好友奖励榜");
	
	private int code;
	private String desc;
	
	private RankType() {
	}
	
	private RankType(int code, String desc) {
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
