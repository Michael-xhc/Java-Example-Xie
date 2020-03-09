package cn.com.sinosafe.xiecommon.enums;

/**
 * 好伙伴业务状态
 * 
 * @author huyang
 *
 */
public enum MsgTemplates {
    /** 消息模板 **/
	Template_1(1, "{X}，{XX}**的好友为他赚取了{XXX}元现金"),
	Template_2(1, "{XX}**的好友为他赚取了{XXX}元现金");

    

    private final String msg;
    private final int code;

    private MsgTemplates(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
