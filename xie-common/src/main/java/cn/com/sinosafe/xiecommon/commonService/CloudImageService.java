package cn.com.sinosafe.xiecommon.commonService;

import cn.com.sinosafe.agent.common.code.AgentResponseCode;
import cn.com.sinosafe.agent.common.exception.BusinessException;
import cn.com.sinosafe.agent.common.properte.ImageCloudProperties;
import cn.com.sinosafe.agent.common.utils.JSONUtils;
import cn.com.sinosafe.agent.common.utils.ParamUtils;
import cn.com.sinosafe.agent.common.utils.StringUtils;
import cn.com.sinosafe.lina.image.cloud.ICloudImageApi;
import cn.com.sinosafe.lina.image.cloud.configuration.CloudImageProperties;
import cn.com.sinosafe.lina.image.cloud.dto.BizInfo;
import cn.com.sinosafe.lina.image.cloud.dto.FileInfo;
import cn.com.sinosafe.lina.image.cloud.dto.PathInfo;
import cn.com.sinosafe.lina.image.cloud.dto.UploadInfo;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @Project	: agent-common
 * @Desc	: 华安云影像系统操作
 * @Author	: hesong
 * @Date	: 2020年2月20日 下午5:55:56
 * @Version	: 1.0
 */
@Component
public class CloudImageService {
	private static final Logger logger = LoggerFactory.getLogger(CloudImageService.class);
	
	/**
	 * 影像系统文件编号参数
	 */
	private static final String FILE_ID = "fileId";
	
	/**
	 * 影像系统机构编号参数
	 */
	private static final String ORG_ID = "orgId";
	
	@Autowired
	private CloudImageProperties properties;
	@Autowired
	private ImageCloudProperties imageCloudProperties;
	@Autowired
	private ICloudImageApi cloudImageApi;
	
	/**
	 * @Desc	: 信保代理人项目文件上传（参数从配置文件读取，简化参数传递）
	 * @Author	: hesong
	 * @Date	: 2020年2月20日 下午6:01:34
	 * @param imageParam ：文件参数
	 * @throws Exception 
	 */
	public FileInfo uploadFiles4Agent(JSONObject imageParam) throws Exception {
		// 业务参数，必传
		Map<String, String> paramMap = new HashMap<String, String>(16);
		// 用户编号或者身份证号，必传
		paramMap.put("operator", imageParam.getString("userId"));
		// 用户姓名，必传
		paramMap.put("operatorName", imageParam.getString("userName"));
		// 业务流水号，必传
		paramMap.put("businessNo", imageParam.getString("serno"));
		// 上传的文件目录配置参数key，必传，在配置文件的lina.image.cloud.paths下的每个子节点，多个节点建议把key配置成枚举值
		paramMap.put("pathInfoKey", imageParam.getString("pathInfoKey"));
		// 待上传文件的本地路径，必传
		paramMap.put("localFile", imageParam.getString("localFile"));
		// 文件编号，如果不传则影像系统自行生成，非必传
		if (imageParam.containsKey(FILE_ID)) {
			paramMap.put("fileId", imageParam.getString(FILE_ID));
		}
		
		// 操作者机构编号，非必传，不传则取配置的默认值（前提是配置文件中已配置该值）
		if (imageParam.containsKey(ORG_ID) && StringUtils.isNotEmpty(imageParam.getString(ORG_ID))) {
			paramMap.put("comCode", imageParam.getString(ORG_ID));
		} else {
			paramMap.put("comCode", imageCloudProperties.getOrgId());
		}
		// 配置参数
		paramMap.put("password", properties.getPassword());
		paramMap.put("roleCode", imageCloudProperties.getRoleCode());
		paramMap.put("appCode", imageCloudProperties.getAppCode());
		paramMap.put("classCode", imageCloudProperties.getClassCode());
		
		return uploadFile(paramMap);
	}
	
	
	/**
	 * @Desc	: 通用文件上传云影像系统
	 * @Author	: hesong
	 * @Date	: 2020年2月21日 下午3:57:37
	 * @param paramMap	:	影响上传参数
	 * @throws Exception 
	 */
	public FileInfo uploadFile(Map<String, String> paramMap) throws Exception {
		// 上传操作人所属机构码，必传
		String comCode = paramMap.get("comCode");
		// 上传操作人标识，必传
		String operator = paramMap.get("operator");
		// 上传操作人名称，必传
		String operatorName = paramMap.get("operatorName");
		// 业务标识，必传
		String businessNo = paramMap.get("businessNo");
		// 上传目录key值（在配置文件中），必传
		String pathInfoKey = paramMap.get("pathInfoKey");
		// 待上传文件在本地的路径，必传
		String localFile = paramMap.get("localFile");
		// 影像系统接口密码，必传
		String password = paramMap.get("password");
		// 影像系统角色代码，必传
		String roleCode = paramMap.get("roleCode");
		// 影像系统分配的系统编码，必传
		String appCode = paramMap.get("appCode");
		// 影像系统分配的模块（子系统）代码，必传
		String classCode = paramMap.get("classCode");
		// 文件编号，非必传
		String fileId = paramMap.get("fileId");
		
		// 校验参数
		ParamUtils.notEmpty(comCode, "comCode");
		ParamUtils.notEmpty(operator, "operator");
		ParamUtils.notEmpty(operatorName, "operatorName");
		ParamUtils.notEmpty(businessNo, "businessNo");
		ParamUtils.notEmpty(pathInfoKey, "pathInfoKey");
		ParamUtils.notEmpty(localFile, "localFile");
		ParamUtils.notEmpty(password, "password");
		ParamUtils.notEmpty(roleCode, "roleCode");
		ParamUtils.notEmpty(appCode, "appCode");
		ParamUtils.notEmpty(classCode, "classCode");
		
		// 参数配置信息
		BizInfo bizInfo = getBizInfoParam(comCode, operator, operatorName, businessNo, roleCode, appCode, classCode, password);
		
		// 上传目录信息
		PathInfo pathInfo = this.properties.getPaths().get(pathInfoKey);
		
		// 组装上传信息
		UploadInfo uploadInfo = getUploadInfoParam(localFile, pathInfo, fileId);
		
		// 执行上传操作
		FileInfo fileInfo = cloudImageApi.uploadFile(bizInfo, uploadInfo);
		logger.info("【华安云影像-文件上传】结果{}，bizInfo请求参数{}，uploadInfo请求参数{}", 
				JSONUtils.getSingleInstance().toJSon(fileInfo), JSONUtils.getSingleInstance().toJSon(bizInfo), JSONUtils.getSingleInstance().toJSon(uploadInfo));
		return fileInfo;
	}
	
	/**
	 * 根据影像编号查询影像
	 * @Author	: hesong
	 * @Date	: 2020年2月21日 下午6:44:39
	 * @param fileIds 影像编号（可以参数，支持多个）
	 * @return	: 影像信息FileInfo列表
	 */
	public List<FileInfo> queryFiles(String... fileIds){
		if (fileIds.length < 0) {
			 logger.error(String.format("参数校验失败,[%s]为空", fileIds));
	         throw new BusinessException(AgentResponseCode.NULL_PARAM);
		}
		return cloudImageApi.queryFiles(fileIds);
	}
	
	/**
	 * 获取云影像的请求参数
	 * @param comCode 机构代码，eg:0101
	 * @param operator 操作员编码，eg:hesong@sinosafe.com.cn
	 * @param operatorName 操作员姓名，eg:何松
	 * @param businessNo 业务流水号
	 * @param roleCode 影像系统角色代码
	 * @param appCode 影像系统分配的系统编码
	 * @param classCode 影像系统分配的模块（子系统）代码
	 * @param password 影像系统接口密码
	 * @return	:
	 */
	private BizInfo getBizInfoParam(String comCode, String operator, String operatorName,
                                    String businessNo, String roleCode, String appCode, String classCode, String password) {
		BizInfo bizInfo = new BizInfo();
		bizInfo.setRedirect(false);
		bizInfo.setComCode(comCode);
		bizInfo.setOperator(operator);
		bizInfo.setOperatorName(operatorName);
		bizInfo.setBusinessNo(businessNo);
		bizInfo.setPassword(properties.getPassword());
		bizInfo.setOperatorRole(imageCloudProperties.getRoleCode());
		bizInfo.setAppCode(imageCloudProperties.getAppCode());
		bizInfo.setClassCode(imageCloudProperties.getClassCode());
		return bizInfo;
	}
	
	
	/**
	 * 组装上传信息
	 * @Author	: hesong
	 * @Date	: 2020年2月21日 下午6:33:06
	 * @param localFile	本地文件全路径
	 * @param pathInfo	上传的目录信息
	 * @param fileId	文件编号
	 * @return	:
	 */
	private UploadInfo getUploadInfoParam(String localFile, PathInfo pathInfo, String fileId) {
		UploadInfo uploadInfo = new UploadInfo();
		uploadInfo.setFile(new File(localFile));
		uploadInfo.setPathInfo(pathInfo);
		if (StringUtils.isNotEmpty(fileId)) {
			uploadInfo.setFileId(fileId);
		}
		return uploadInfo;
	}
	
	
}
