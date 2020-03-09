package cn.com.sinosafe.xiecommon.enums;

/**
 * 好伙伴业务状态
 * 
 * @author huyang
 *
 */
public enum ApplyStep {
    /** 申请步骤 **/
    PAGE_1(1, "未申请"), PAGE_2(2, "完成实名认证"), PAGE_3(3, "执业信息保存完成"), PAGE_4(4, "执业考试完成"),
    PAGE_5(5, "人脸识别完成"), PAGE_6(6, "征信授权书签署完成");

    

    private final String msg;
    private final int code;

    private ApplyStep(int code, String msg) {
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
