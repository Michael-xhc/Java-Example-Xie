package cn.com.sinosafe.xiecommon.utils;

import java.math.BigDecimal;

/**
 * @ClassName:  AgentConstants   
 * @Description:常量类   
 * @author: HuYang
 * @date:   2020年2月11日 下午7:40:47      
 * @Copyright:  
 */
public class AgentConstants {
	/**
	 * 登录验证码校验redis key值
	 */
	public static final String LOGIN_MSG_REDIS_KEY = "login_msg_redis_key:";

	/**
	 * 注册验证码校验redis key值
	 */
	public static final String REGISER_MSG_REDIS_KEY = "regiser_msg_redis_key:";
	
	/**
	 * 邀请链接有效期缓存redis key值
	 */
	public static final String INVITER_URL_REDIS_KEY = "inviter_url_redis_key:";

	/**
	 * 实名认证验证码校验redis key值 Authentication
	 */
	public static final String AUTHENTICATION_MSG_REDIS_KEY = "authentication_msg_redis_key:";

	/**
	 * 添加银行卡校验redis key值 Authentication
	 */
	public static final String ADD_BANKCARD_MSG_KEY = "addbankcard_msg_redis_key:";
	
	/**
	 * 登录/注册短信验证码 redis有效时间  单位:秒,共计1分钟
	 */
	public static final long LOGIN_MSG_EXPIRE_TIME = 60;

	/**
	 * 登录token前缀
	 */
	public static final String LOGIN_TOKEN_PREFIX = "login_token_prefix_";
	
	/**
	 * 登录token redis有效时间 单位:秒,共计30天
	 */
	public static final long LOGIN_TOKEN_EXPIRE_TIME = 60 * 60 * 24 * 7;
	
	/**
	 * 产品综合费率redis key值
	 */
	public static final String PROD_RATE_REDIS_KEY = "prod_rate_redis_key:";
	
	/**
	 * 产品综合费率redis有效时间 单位:秒,共计1天
	 */
	public static final long PROD_RATE_EXPIRE_TIME = 60 * 60 * 24;
	
	/**
	 * 银行费率redis key值
	 */
	public static final String BANK_RATE_REDIS_KEY = "bank_rate_redis_key:";
	
	/**
	 * 银行费率redis有效时间 单位:秒,共计1天
	 */
	public static final long BANK_RATE_EXPIRE_TIME = 60 * 60 * 24;
	
	/**
	 * 邀请链接redis有效时间 单位：秒，共48小时
	 */
	public static final long INVITER_URL_EXPIRE_TIME = 60 * 60 * 48;
	
	/**
	 * 邮箱验证码校验redis key值
	 */
	public static final String EMAIL_MSG_REDIS_KEY = "email_msg_redis_key:";
	
	/**
	 * 邮箱验证码有效时间
	 */
	public static final long EMAIL_MSG_EXPIRE_TIME = 30 * 60 * 1000;
	
	/**
	 * 查询字典的redis key值
	 */
	public static final String SYSTEM_CONFIG_REDIS_KEY = "system_config_redis_key:";
	/**
	 * 查询字典有效时间
	 */
	public static final long SYSTEM_CONFIG_EXPIRE_TIME =30 * 12 * 60 * 60 * 1000;
	/**
     * 影像资料上传重试次数
     */
    public static final int RETRY_TIMES = 3;
    
	/**
	 * 绑定手机变更短信验证码 redis有效时间  单位:秒,共计1分钟
	 */
	public static final long UPDATE_PHONE_MSG_EXPIRE_TIME = 60;
	
	/**
	 * 绑定邮箱变更验证码 redis有效时间  单位:秒,共计30分钟
	 */
	public static final long UPDATE_PHONE_EMAIL_EXPIRE_TIME = 60 * 30;
	
	/**
	 * 绑定客户经理变更短信验证码 redis有效时间  单位:秒,共计1分钟
	 */
	public static final long UPDATE_BIND_MANAGER_EXPIRE_TIME = 60;
	
	/**
	 * 用户登录密码短信验证码 redis有效时间  单位:秒,共计1分钟
	 */
	public static final long UPDATE_PASSWORD_EXPIRE_TIME = 60;
	
	/**
	 * 当日保费收入top3缓存redis key值
	 */
	public static final String PREMIUM_RANK_LIST_TOP3_REDIS_KEY = "premium_rank_list_top3_redis_key:";
	
	/**
	 * 当日放款金额top3缓存redis key值
	 */
	public static final String LOAN_AMOUNT_RANK_LIST_TOP3_REDIS_KEY = "loan_amount_rank_list_top3_redis_key:";
	
	/**
	 * 当日预审通过笔数top3缓存redis key值
	 */
	public static final String APPROVE_RANK_LIST_TOP3_REDIS_KEY = "approve_rank_list_top3_redis_key:";

    /**
     * 消息列表首页标识
     */
	public static final String HOME_FLAG = "1";
	
	/**
	 * 年均佣金估算默认值,单位：元
	 */
	public static final long DEFAULT_AGENT_PAI = 78000;
	
	/**
	 * 未做业务时下一等级默认佣金
	 */
	public static final BigDecimal DEFAULT_NEXT_COMMISION = new BigDecimal("68000");
	
	/**
	 * 笔均佣金估算默认值,单位：元
	 */
	public static final long DEFAULT_AGENT_PER = 1760;
	
	/**
	 * 代理人估算佣金缓存redis key值
	 */
	public static final String AGENT_COMMISION_ESTIMATE_REDIS_KEY = "agent_commision_estimate_redis_key:";

    /**
     * 信保系统产品信息列表缓存redis key值
     */
    public static final String XB_PRODUCT_INFO_REDIS_KEY = "xb_product_info_redis_key:";
	
	/**
	 * 默认创建人
	 */
	public static final String DEFAULT_CREATER = "system";
	
	/**
	 * 获得佣金及奖励默认冻结天数T+3
	 */
	public static final int FREEZE_DAY = 3;
	
	/**
	 * 校验日期格式满足yyyy-MM-dd正则表达式
	 */
	public static final String DATE_YYYY_MM_DD_REG = "^((?:19|20)\\d\\d)-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";

    /**
     * 亚联接口--开户行识别
     */
	public static final String BIG_DATE_TYPE = "1359";

	/**
	 * 二维码识别链接
	 */
	public static final String QR_URL_REDIS_KEY = "qr_code_redis_key_";

    /**
     *二维码链接redis有效时间 单位：秒，共24小时
     */
    public static final long QR_CODE_URL_EXPIRE_TIME = 60 * 60 * 24;

    /**
     * 解析经纬度获取省市区国标编码URL
     */
    public static final String GAODE_REGEO_URL = "https://proxy.sinosafe.com.cn/haxb_geocode";

    /**
     * 解析经纬度获取省市区国标编码 key值
     */
    public static final String GAODE_REGEO_KEY = "f8509f71cd615b295d9956012cc095c2";
    
    /**
     * 登录短信模板
     */
    public static final String LOGIN_MSG = "你正在登录信代专家平台，验证码：%s。转发可能导致账号被盗。如非本人操作，请忽略本短信。";
    
    /**
     * 更换密码短信模板
     */
    public static final String UPDATE_PWD_MSG = "你正在信代专家平台更换密码，验证码：%s。转发可能导致账号被盗。如非本人操作，请忽略本短信。";
    
    /**
     * 更换客户经理短信模板
     */
    public static final String UPDATE_MANAGER_MSG = "你正在信代专家平台更换关联客户经理，验证码：%s。如非本人操作，请忽略本短信。";
    
    /**
     * 绑定邮箱标题
     */
    public static final String TITLE_UPDATE_BIND_EMAIL = "【华安保险】信代专家平台绑定邮箱提醒";
    
    /**
     * 绑定邮箱内容
     */
    public static final String CONTENT_UPDATE_BIND_EMAIL = "你正在信代专家平台绑定邮箱，验证码：%s。转发可能导致账号被盗。如非本人操作，请忽略本邮件。";
    
    /**
     * 解绑邮箱标题
     */
    public static final String TITLE_UPDATE_UNBIND_EMAIL = "【华安保险】信代专家平台解绑邮箱提醒";
    
    /**
     * 解绑邮箱内容
     */
    public static final String CONTENT_UPDATE_UNBIND_EMAIL = "你正在信代专家平台解绑邮箱，验证码：%s。转发可能导致账号被盗。如非本人操作，请忽略本邮件。";
    
    /**
     * 绑定新手机短信模板
     */
    public static final String BIND_NEW_PHONE_MSG = "你正在信代专家平台绑定手机号，验证码：%s。转发可能导致账号被盗。如非本人操作，请忽略本短信。";
    
    /**
     * 解绑手机短信模板
     */
    public static final String UNBIND_PHONE_MSG = "你正在信代专家平台解绑手机号，验证码：%s。转发可能导致账号被盗。如非本人操作，请忽略本短信。";
    
    /**
     * 解绑手机短信模板
     */
    public static final String USER_REGISTER_MSG = "你正在注册信代专家平台账号，验证码：%s。如非本人操作，请忽略本短信。";

    /**
     * 实名认证手机短信模板
     */
    public static final String AUTHENTICATION_MSG = "你正在信代专家平台申请成为代理人，验证码：%s。转发可能导致账号被盗。如非本人操作，请忽略本短信。";

    /**
     * 上传影像系统标识
     */
    public static final String EDUCARD = "EDUCARD";

    /**
     * 信代专家在UM系统标识
     */
    public static final String XBAGENT = "xbagent";
    
    /**
	 * 工作台环形图数据 redis key值
	 */
	public static final String WORKBENCH_DATA_REDIS_KEY = "workbench_data_redis_key:";
	
	/**
	 * 工作台环形图数据 redis key值 有效时间1小时
	 */
	public static final long WORKBENCH_DATA_EXPIRE_TIME = 60 * 60;
    
    /**
     * 不含税保费计算值 1.06
     */
    public static final BigDecimal TAX_RATE = new BigDecimal("1.06");
    /**
     * 100
     */
    public static final BigDecimal YB = new BigDecimal("100");
    
    /**
     * 币种
     */
    public static final String CURRENCY = "CNY";

	/**
	 * 公告消息1
	 */
	public static final String NEW1 = "成为代理人，人均年收入 %s 元。";

	/**
	 * 公告消息2
	 */
	public static final String NEW2 = "HOT邀请好友，一起赚钱！";

    /**
     * 公告消息--消息列表后缀
     */
    public static final String MESSAGE = "/mine/message";

    /**
     * 公告消息--信代专家介绍后缀
     */
    public static final String CBINTRODUCE = "/xbIntroduce";

    /**
     * 公告消息--邀请好友后缀
     */
    public static final String INVITATION = "/mine/invitation";
    
    /**
     * 放款通知接收MQ
     */
    public static final String MQ_LOAN = "ha.queue_account_xd_expert";
    
    /**
     * 用户手机号更新短信模板
     */
    public static final String UPDATE_PHONE_FROM_SALE_MSG = "尊敬的信代专家用户，您在我司登记的代理人手机号已通过其他途径变更为%s，您在信代专家的登录账号也将同步更换为该手机号，登录密码仍为原密码。如有疑问，请联系您的专属客服：%s.";
    
    /**
     * 代理人申请成功短信通知模板
     */
    public static final String AGENT_APPLY_SUCCESS_MSG = "您在华安信代专家申请成为华安保险代理人的资料已通过审核！恭喜您正式成为华安签约代理人，您可以在信代专家平台上正常分享、代理华安信保旗下产品。快关注“华安信保”微信公众号，开启赚钱之旅吧！";
    
    /**
     * 佣金方案过期提醒邮件主题
     */
    public static final String TITLE_CASE_OVERDUE = "【信代专家平台佣金方案过期提醒】";
}
