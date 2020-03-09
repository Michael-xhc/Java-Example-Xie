package cn.com.sinosafe.xiecommon.properte;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 功能说明：云影像的配置
 * 
 * @author liansonghui
 * @version 1.0.0
 * @time 2018年2月27日
 */
@Component
@RefreshScope
@ConfigurationProperties(prefix = "imagecloud")
public class ImageCloudProperties {

	/**
	 * 二级目录编码 UW
	 */
	@Value("${imagecloud.appCode}")
	private String appCode;
	
	/**
	 * 三级目录编码 UW_D
	 */
	@Value("${imagecloud.classCode}")
	private String classCode;
	
	/**
	 * 角色代码
	 */
	@Value("${imagecloud.roleCode}")
	private String roleCode;
	
	/**
	 * 【HTTP】通过专线下载影像文件
	 */
	@Value("${imagecloud.downloadByFileId}")
	private String downloadByFileId;
	
	/**
	 * 默认的操作影像的机构编码
	 */
	@Value("${imagecloud.orgId}")
	private String orgId;

 
	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getDownloadByFileId() {
		return downloadByFileId;
	}

	public void setDownloadByFileId(String downloadByFileId) {
		this.downloadByFileId = downloadByFileId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
 
	
}
