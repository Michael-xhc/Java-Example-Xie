package cn.com.sinosafe.xiecommon.code;

/**
 * @ClassName:  ResultCode   
 * @Description:返回结果编码   
 * @author: HuYang
 * @date:   2020年2月11日 下午4:05:26      
 * @Copyright:
 */
public class ResultCode {
	public static final ResultCode FAIL = new ResultCode(0, "系统开小差了，请稍候再试");
	public static final ResultCode SUCCESS = new ResultCode(1, "请求成功");
    public static final ResultCode INVALID_PARAM = new ResultCode(200, "Invalid parameter(s)");
    public static final ResultCode INVALID_SESSION = new ResultCode(100, "Invalid session");
    public static final ResultCode SERVER_ERROR = new ResultCode(500, "Server internal error");
    public static final ResultCode NET_WORK_ERROR = new ResultCode(600, "network error");
    public static final ResultCode INVALID_TOKEN = new ResultCode(1000, "Auth token failed");
    public static final ResultCode LOGIN_FAILED = new ResultCode(1001, "Login failed");
    public static final ResultCode INVALID_IP = new ResultCode(1002, "Invalid ip address");
    public static final ResultCode INVALID_SIGNATURE = new ResultCode(1005, "Invalid Signature");

    protected ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof ResultCode && this.code == ((ResultCode) obj).getCode();
    }

    public boolean equals(int code) {
        return this.code == code;
    }

    private final int code;
    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
