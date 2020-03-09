package cn.com.sinosafe.xiecommon.code;

/**
 * @ClassName:  AgentResponseCode   
 * @Description:自定义异常业务编码  
 * @author: HuYang
 * @date:   2020年2月11日 下午4:06:07      
 * @Copyright:
 */
public class AgentResponseCode extends ResultCode {

	protected AgentResponseCode(int code, String message) {
        super(code, message);
    }

    public static final ResultCode NULL_PARAM = new ResultCode(1000000, "参数[%s]不能为空");
    public static final ResultCode ERROR_PASSWORD = new ResultCode(1000001, "账号不存在或密码不正确!");
    public static final ResultCode ERROR_LOGIN_TYPE = new ResultCode(1000002, "不支持的登录类型");
    public static final ResultCode NULL_USER = new ResultCode(1000003, "账号不存在!");
    public static final ResultCode UN_LOGIN_USER = new ResultCode(1000004, "账号不可用!");
    public static final ResultCode LOGIN_ERROR_MSG_CODE = new ResultCode(1000005, "验证码错误或超时");
    public static final ResultCode LOGIN_UN_BIND_WECHAT = new ResultCode(1000006, "未绑定微信登录");
    public static final ResultCode LOGIN_SESSION_EXPIRED = new ResultCode(1000007, "您的账号缓存已过期,请重新登录");
    public static final ResultCode EXIST_USER = new ResultCode(1000008, "手机号已被注册!");
    public static final ResultCode VALIDATE_ID_ERROR = new ResultCode(1000009, "身份证无效!");
    public static final ResultCode ERROR_FILE_SUFFIX = new ResultCode(1000010, "文件格式不对");
    public static final ResultCode ERROR_MAX_FILENAME = new ResultCode(1000011, "文件名长度超过最大限制");
    public static final ResultCode ID_CARD_EXPIRE_ERROR = new ResultCode(1000012, "身份证已过期,请更换有效身份证");
    public static final ResultCode IDCARD_OCR_ERROR = new ResultCode(1000013, "身份证识别失败，请重新识别");
    public static final ResultCode BANKCARD_OCR_ERROR = new ResultCode(1000014, "银行卡识别失败，请重新识别");
    public static final ResultCode UNSUPPORTED_OCR_TYPE = new ResultCode(1000015, "暂不支持的识别类型");
    public static final ResultCode UNSUPPORTED_MSG_TYPE = new ResultCode(1000016, "短信类型错误");
    public static final ResultCode UNSUPPORTED_EMAIL_TYPE = new ResultCode(1000017, "邮箱类型错误");
    public static final ResultCode ERROR_ORIGIN_PHONE = new ResultCode(1000018, "现绑定手机号码不正确");
    public static final ResultCode ERROR_ORIGIN_EMAIL = new ResultCode(1000019, "现绑定邮箱不正确");
    public static final ResultCode UPDATE_ERROR_MSG_CODE = new ResultCode(1000020, "验证码错误或超时");
    public static final ResultCode EXISTS_PHONE = new ResultCode(1000021, "该手机号已经被使用");
    public static final ResultCode EXISTS_EMAIL = new ResultCode(1000022, "该邮箱已经被使用");
    public static final ResultCode ERROR_OPENID = new ResultCode(1000023, "openId验证不通过");
    public static final ResultCode MANAGER_UN_DISABLE = new ResultCode(1000024, "该客户经理已停牌！");
    public static final ResultCode MANAGER_NOT_EXISTS = new ResultCode(1000025, "客户经理手机号不存在");
    public static final ResultCode CREDIT_SEND_MSG_ERROR = new ResultCode(1000026, "授权签署短信发送失败");
    public static final ResultCode CREDIT_REGISTER_ERROR = new ResultCode(1000027, "安心签开户失败");
    public static final ResultCode CREDIT_VERIFY_MSGCODE_ERROR = new ResultCode(1000028, "验证码超时或错误");
    public static final ResultCode CREDIT_CONTRACT_SIGN_ERROR = new ResultCode(1000029, "征信合同签署失败");
    public static final ResultCode CREDIT_CONTRACT_UPLOAD_ERROR = new ResultCode(1000030, "征信合同商上传失败");
    public static final ResultCode ERROR_RANK_TYPE = new ResultCode(1000031, "榜单排行类型错误");
    public static final ResultCode BANKCARD_NOT_EXISTS = new ResultCode(1000032, "银行卡卡号不存在");
    public static final ResultCode BASE_USER_INFO_NOT_EXISTS = new ResultCode(1000033, "用户基本信息不存在或状态不可用");
    public static final ResultCode COMMISION_DETAILS_EXISTS = new ResultCode(1000034, "佣金明细已存在,不允许重复插入");
    public static final ResultCode USERID_NOT_EXISTS = new ResultCode(1000035, "用户不存在");
    public static final ResultCode QUERY_AGENT_EXCEPTION = new ResultCode(1000036, "调用销管系统查询代理人异常");
    public static final ResultCode ADD_AGENT_EXCEPTION = new ResultCode(1000037, "调用销管系统添加代理人异常");
    public static final ResultCode UPDATE_AGENT_EXCEPTION = new ResultCode(1000038, "调用销管系统更新代理人异常");
    public static final ResultCode ORDINARY_EXCLUSIVE_AGENT = new ResultCode(1000039, "您已是华安代理人，但代理类型不符，请联系您的业务员处理！");
    public static final ResultCode INDEPENDENT_AGENT = new ResultCode(1000040, "您已通过其他途径成为华安保险代理人，请核实信息是否正确！");
    public static final ResultCode AGENT_APPLICATION= new ResultCode(1000041, "您存在代理申请正在审核中，请审核后再试！");
    public static final ResultCode SERNO_NOT_EXIST= new ResultCode(1000042, "业务流水号不存在");
    public static final ResultCode SETTLE_PLAN_EXIST= new ResultCode(1000043, "费用结算计划已存在");
    public static final ResultCode INVITER_NOT_EXIST= new ResultCode(1000044, "邀请人不存在或者不是代理人");
    public static final ResultCode INVITER_TYPE_ERROR= new ResultCode(1000045, "邀请人类型错误");
    public static final ResultCode INVITER_URL_EXPIRED= new ResultCode(1000046, "邀请链接已失效");
    public static final ResultCode NO_SETTLE_PLAN= new ResultCode(1000047, "未查询到可结算期次计划");
    public static final ResultCode SETTLE_AMOUNT_ERROR = new ResultCode(1000048, "提现金额和当前保单结算计划汇总金额不相等,请刷新重试");
    public static final ResultCode QUERY_TAX_ERROR = new ResultCode(1000049, "调用费管个税试算接口异常");
    public static final ResultCode SUBMIT_WITHDRAWAL_EXCEPTION = new ResultCode(1000050, "调用费管结算申请接口异常");
    public static final ResultCode WITHDRAWAL_FAIL = new ResultCode(1000051, "提现失败");
    public static final ResultCode UPDATE_SALE_BANK_ERROR = new ResultCode(1000052, "提现失败，请重试或更换银行卡");
    public static final ResultCode USER_FREEZE = new ResultCode(1000053, "您的账号被冻结,请联系管理员处理.");
    public static final ResultCode KICK_FREEZE = new ResultCode(1000054, "您的账号被永久封号,无法登录.");
    public static final ResultCode GAODE_REGEO_ERROR = new ResultCode(1000055, "高德地图获取地理编码失败！");
    public static final ResultCode GAODE_REGEO_SELECT_ERROR = new ResultCode(1000056, "申请位置所属市定位失败");
    public static final ResultCode FILE_MAX_SIZE = new ResultCode(1000057, "文件大小不能超过10M");
    public static final ResultCode FORBID_APPLY_AGENT = new ResultCode(1000058, "根据监管要求,公司内部员工不可申请为个人代理人!");
    public static final ResultCode ERROR_AGENT_TYPE = new ResultCode(1000059, "您已是华安代理人，但代理类型不符，请联系您的业务员处理!");
    public static final ResultCode ERROR_AGENT_AREA = new ResultCode(1000060, "地区查询无结果!");
    public static final ResultCode MANAGER_INFO_ERROR = new ResultCode(1000061, "关联客户经理信息不完整");
    public static final ResultCode QUERY_MANAGER_INFO_EXCEPTION = new ResultCode(1000062, "查询客户经理异常");
    public static final ResultCode NO_DEFAULT_LEVEL_INFO = new ResultCode(1000063, "未查询到默认代理人等级信息");
    public static final ResultCode MANAGER_NOT_BELONG = new ResultCode(1000064, "该客户经理不负责您的代理区域");
    public static final ResultCode ERROR_AGENT_INDUSTRY = new ResultCode(1000064, "行业查询无结果");
    public static final ResultCode ERROR_QUERY_PRODUCT_RATE = new ResultCode(1000065, "查询产品费率失败");
    public static final ResultCode BANKCARD_EXISTS = new ResultCode(1000065, "银行卡已存在");
    public static final ResultCode ERROR_PARAM_SUFFIX = new ResultCode(1000066, "参数格式不对");
    public static final ResultCode ERROR_SIGN = new ResultCode(1000067, "签名验证失败");
    public static final ResultCode APPLY_SIGN_ERROR = new ResultCode(1000068, "申请签署合同异常,请联系管理员处理!");
    public static final ResultCode APPLY_RESULT_ERROR = new ResultCode(1000069, "审核结果不支持");
    public static final ResultCode ERROR_XBORGINFO = new ResultCode(1000070, "信保分部查询无结果");
    public static final ResultCode ERROR_WITHDRAWAL = new ResultCode(1000071, "提现失败,请刷新页面重试");
    public static final ResultCode ERROR_DEL_NOTICE = new ResultCode(1000072, "不能删除已发送的消息");
    public static final ResultCode IS_EXIST_PROGRAMME = new ResultCode(1000073, "该区域存在有效方案，不能新增");
    public static final ResultCode INVALID_WECHAT_CODE = new ResultCode(1000074, "微信Code失效");
    public static final ResultCode CHECK_SIGN_ERROR = new ResultCode(1000075, "参数签名验证不通过");
    public static final ResultCode NO_COMMISION = new ResultCode(1000076, "未查询到当前保单对应的佣金信息");
    public static final ResultCode ERROR_ENDOR_TYPE = new ResultCode(1000077, "费用批改类型和批改后保费不匹配");

}
