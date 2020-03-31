package cn.com.sinosafe.xie.user.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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

    public String getUploadAddr() {
        return uploadAddr;
    }

    public void setUploadAddr(String uploadAddr) {
        this.uploadAddr = uploadAddr;
    }

	public BigDecimal getCommissionRatio() {
        return commissionRatio;
    }

    public void setCommissionRatio(BigDecimal commissionRatio) {
        this.commissionRatio = commissionRatio;
    }

    public String getAgentLevelName() {
        return agentLevelName;
    }

    public void setAgentLevelName(String agentLevelName) {
        this.agentLevelName = agentLevelName;
    }

    public String getAgencyAreaCode() {
        return agencyAreaCode;
    }

    public void setAgencyAreaCode(String agencyAreaCode) {
        this.agencyAreaCode = agencyAreaCode;
    }

    public String getSaleAgentCode() {
		return saleAgentCode;
	}

	public void setSaleAgentCode(String saleAgentCode) {
		this.saleAgentCode = saleAgentCode;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getAgentLevelId() {
        return agentLevelId;
    }

    public void setAgentLevelId(Integer agentLevelId) {
        this.agentLevelId = agentLevelId;
    }

    public Integer getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(Integer agentLevel) {
        this.agentLevel = agentLevel;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getPhotoAddr() {
        return photoAddr;
    }

    public void setPhotoAddr(String photoAddr) {
        this.photoAddr = photoAddr == null ? null : photoAddr.trim();
    }

    public Integer getInviterType() {
        return inviterType;
    }

    public void setInviterType(Integer inviterType) {
        this.inviterType = inviterType;
    }

    public String getInviterUserId() {
        return inviterUserId;
    }

    public void setInviterUserId(String inviterUserId) {
        this.inviterUserId = inviterUserId;
    }

    public String getInviterName() {
        return inviterName;
    }

    public void setInviterName(String inviterName) {
        this.inviterName = inviterName == null ? null : inviterName.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getWechatNickName() {
        return wechatNickName;
    }

    public void setWechatNickName(String wechatNickName) {
        this.wechatNickName = wechatNickName == null ? null : wechatNickName.trim();
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId == null ? null : applyId.trim();
    }

    public String getPracticeNumber() {
        return practiceNumber;
    }

    public void setPracticeNumber(String practiceNumber) {
        this.practiceNumber = practiceNumber == null ? null : practiceNumber.trim();
    }

    public Date getLatestLoginTime() {
        return latestLoginTime;
    }

    public void setLatestLoginTime(Date latestLoginTime) {
        this.latestLoginTime = latestLoginTime;
    }

    public String getLatestLoginCity() {
        return latestLoginCity;
    }

    public void setLatestLoginCity(String latestLoginCity) {
        this.latestLoginCity = latestLoginCity == null ? null : latestLoginCity.trim();
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId == null ? null : registrationId.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAgencyAreaName() {
        return agencyAreaName;
    }

    public void setAgencyAreaName(String agencyAreaName) {
        this.agencyAreaName = agencyAreaName;
    }

    public String getBelongOrgName() {
        return belongOrgName;
    }

    public void setBelongOrgName(String belongOrgName) {
        this.belongOrgName = belongOrgName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getAgentLevelStr() {
        return agentLevelStr;
    }

    public void setAgentLevelStr(String agentLevelStr) {
        this.agentLevelStr = agentLevelStr;
    }

    public String getInviterPhone() {
		return inviterPhone;
	}

	public void setInviterPhone(String inviterPhone) {
		this.inviterPhone = inviterPhone;
	}

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getBelongOrgCode() {
        return belongOrgCode;
    }

    public void setBelongOrgCode(String belongOrgCode) {
        this.belongOrgCode = belongOrgCode;
    }
}