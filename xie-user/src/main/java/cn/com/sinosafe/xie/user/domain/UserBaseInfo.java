package cn.com.sinosafe.xie.user.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserBaseInfo implements Serializable {
    /**
     * 用户ID 主键,从100000开始
     */
    private Integer userId;

    /**
     * 用户手机号
     */
    private String phoneNumber;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 代理区域名称
     */
    private String agencyAreaName;

    /**
     * 归属机构名称
     */
    private String belongOrgName;

    /**
     * 归属机构编码
     */
    private String belongOrgCode;

    /**
     * 客户经理名称
     */
    private String managerName;

    /**
     * 客户经理手机
     */
    private String managerPhone;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 盐值 100到999的随机整数
     */
    private Integer salt;

    /**
     * 用户类型 1普通用户2代理人  对应字典表key值:AGENT_USER_TYPE
     */
    private Integer userType;

    /**
     * 代理人等级ID
     */
    private Integer agentLevelId;

    /**
     * 代理人等级
     */
    private Integer agentLevel;

    /**
     * 代理人等级
     */
    private String agentLevelStr;

    /**
     * 账号状态 1正常2代理申请审核3冻结4永久封号 对应字典表key值:AGENT_USER_STATUS
     */
    private Integer userStatus;

    /**
     * 用户头像地址
     */
    private String photoAddr;

    /**
     * 邀请人类型 1内部员工2代理人 字典表key值:AGENT_INVITER_TYPE
     */
    private Integer inviterType;

    /**
     * 邀请人ID
     */
    private String inviterUserId;

    /**
     * 邀请人姓名
     */
    private String inviterName;
    
    /**
     * 邀请人手机号
     */
    private String inviterPhone;

    /**
     * 绑定微信OPENID
     */
    private String openId;

    /**
     * 绑定微信名
     */
    private String wechatNickName;

    /**
     * 代理人申请流水号
     */
    private String applyId;

    /**
     * 执业证号
     */
    private String practiceNumber;

    /**
     * 最近登录时间
     */
    private Date latestLoginTime;

    /**
     * 最近登录地点
     */
    private String latestLoginCity;

    /**
     * 当前登录设备号
     */
    private String registrationId;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 用户姓名
     */
    private  String userName;

    /**
     * 绑定邮箱
     */
    private  String email;

    /**
     * 卡号
     */
    private  String accountNumber;

    private Integer page;

    private Integer rows;
    
    /**
     * 代理人申请状态
     */
    private  String applyStatus;

    
    /**
     * 代理人在销管系统编码
     */
    private String saleAgentCode;

    /**
     * 等级返佣比例 百分制
     */
    private BigDecimal commissionRatio;

    /**
     * 等级称号
     */
    private String agentLevelName;

    /**
     * 代理区域编码
     */
    private String agencyAreaCode;

    /**
     * 影像平台地址
     */
    private String uploadAddr;
}