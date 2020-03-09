///**
// *
// */
//package cn.com.sinosafe.xiecommon.commonService;
//
//import cn.com.sinosafe.agent.common.entity.FaceID;
//import cn.com.sinosafe.agent.common.utils.DateUtils;
//import cn.com.sinosafe.agent.common.utils.HttpUtil;
//import cn.com.sinosafe.agent.common.utils.SystemConfigUtils;
//import cn.com.sinosafe.lina.fileupload.FileUploadProperties;
//import cn.com.sinosafe.lina.fileupload.common.UploadFileUtils;
//import cn.com.sinosafe.lina.fileupload.constants.UploadFileConstant;
//import cn.com.sinosafe.lina.fileupload.enums.ErrorType;
//import cn.com.sinosafe.lina.fileupload.enums.PersistenceType;
//import cn.com.sinosafe.lina.fileupload.enums.ReturnType;
//import cn.com.sinosafe.lina.fileupload.exception.UploadImageException;
//import com.alibaba.dubbo.common.utils.StringUtils;
//import com.yzj.trans.FileBean;
//import com.yzj.trans.FileUpload;
//import net.coobird.thumbnailator.Thumbnails;
//import org.apache.commons.io.FileUtils;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.mime.HttpMultipartMode;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.*;
//
///**
//* <p>Title: ImageProcessService</p>
//* <p>Description: </p>
//* @author longxiaoqiang
//* @date 2020年2月15日
//*/
//@Component
//public class ImageProcessService {
//
//	Logger logger = LoggerFactory.getLogger(ImageProcessService.class);
//
//	@Autowired
//	FaceID faceID;
//	@Autowired
//	SystemConfigUtils systemConfigUtils;
//	@Autowired
//    FileUploadProperties fileUploadProperties;
//	/**
//     * 图片压缩
//     *
//     * @param uploadFile
//     * @param imgSuffix
//     * @return
//     */
//    public MultipartFile compressImg(MultipartFile uploadFile, String imgSuffix, String filePath, String compressFile) {
//        File descFile = new File(filePath);
//        try {
//            uploadFile.transferTo(descFile);
//            // 按照原始照片大小比例开始压缩
//            Thumbnails.of(filePath).scale(0.7f).toFile(compressFile);
//            File file = new File(compressFile);
//            FileInputStream input = new FileInputStream(file);
//            MultipartFile multipartFile =
//                new MockMultipartFile(UUID.randomUUID().toString() + "." + imgSuffix, file.getName(), null, input);
//
//            return multipartFile;
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//        	cn.com.sinosafe.agent.common.utils.FileUtils.deleteFile(filePath);
//        	cn.com.sinosafe.agent.common.utils.FileUtils.deleteFile(compressFile);
//        }
//
//        return null;
//    }
//
//    /**
//     * OCR识别
//     *
//     * @param uploadFile
//     * @return
//     * @throws IOException
//     */
//    public String ocrImg(MultipartFile multipartFile, String reqUrl) throws IOException {
//        // 封装请求参数
//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.setCharset(java.nio.charset.Charset.forName("UTF-8"));
//        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//        builder.addBinaryBody("image", multipartFile.getInputStream(), ContentType.MULTIPART_FORM_DATA,
//            multipartFile.getOriginalFilename());
//        builder.addTextBody("api_key", faceID.getApiKey());
//        builder.addTextBody("api_secret", faceID.getApiSecret());
//        // 发送请求
//        return HttpUtil.sendOcrPost(reqUrl, builder);
//    }
//
//    /**
//     * 上传文件到影像系统
//     *
//     * @param uploadFile
//     *            文件对象
//     * @param retryTimes
//     *            可重试次数
//     * @param deleteLocalFiles
//     *            是否删除本地临时文件
//     */
//    // @Async
//    public void uploadFileToImgSys(List<MultipartFile> files, String fileType, int retryTimes, boolean deleteLocalFiles,
//                                   String serno) {
//        // 影像上传系统编号
//    	Map<String, Object> configMap = systemConfigUtils.getValue("GD_IMG_UPLOAD");
//        String prdcode = (String)configMap.get("cop.h5.prd.code");
//        try {
//            // 持久化到本地临时目录
//            List<Object> persistenceFiles =
//                persistenceFiles(files, PersistenceType.UUID_NAME, ReturnType.FILE, null);
//            // 上传到影像系统
//            if (persistenceFiles != null && !persistenceFiles.isEmpty()) {
//                List<File> fileList = new ArrayList<File>(persistenceFiles.size());
//                for (Object obj : persistenceFiles) {
//                    File file = (File)obj;
//                    fileList.add(file);
//                }
//                List<FileBean> fileBeanList = buildBeanListByFile(fileList, fileType);
//                Map<String, String> uploadParam = buildParamMap(prdcode, serno, fileType);
//                // 上传成功后的FIleId
//                uploadImgToImageSystem(fileBeanList, uploadParam, retryTimes,
//                    deleteLocalFiles);
//            }
//        } catch (Exception e) {
//            logger.error("上传影像系统失败", e);
//        }
//    }
//
//    /**
//     * @param multipartFiles
//     * @param persistenceType
//     * @param returnType
//     * @return
//     * @throws UploadImageException
//     */
//    public List<Object> persistenceFiles(List<MultipartFile> multipartFiles, PersistenceType persistenceType,
//                                         ReturnType returnType, String businessFilePath) throws UploadImageException {
//        List<Object> resultList = new ArrayList<>();
//        if (multipartFiles != null && multipartFiles.size() > 0) {
//            for (MultipartFile multipartFile : multipartFiles) {
//                if (multipartFile != null) {
//                    Object result = persistenceFile(multipartFile, persistenceType, returnType, businessFilePath);
//                    resultList.add(result);
//                }
//            }
//        }
//        return resultList;
//    }
//    /**
//     * 封装影像上传文件参数
//     *
//     * @param files
//     * @param fileType
//     * @return
//     */
//    public List<FileBean> buildBeanListByFile(List<File> files, String fileType) {
//        List<FileBean> fileList = new ArrayList<FileBean>();
//        if (files == null || files.isEmpty()) {
//            return fileList;
//        }
//        FileBean fileBean = null;
//        File file = null;
//        for (int i = 0; i < files.size(); i++) {
//            fileBean = new FileBean();
//            file = files.get(i);
//            // 文件路径
//            String filePath = file.getAbsolutePath();
//            // 原文件名
//            String oldFileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1, filePath.length());
//            // 同步到影像系统的新文件名
//            String newFileName =
//                UUID.randomUUID().toString().toUpperCase() + oldFileName.substring(oldFileName.lastIndexOf("."));
//            // 这个是有UUID32生成加上【.文件类型】,这个在你数据表上应该保存下来
//            fileBean.setFileId(newFileName);
//            // 原文件名称
//            fileBean.setFileName(oldFileName);
//            // 文件路径
//            fileBean.setFilePath(filePath);
//            // 这里需要换成红色选择框里面的值GFX_00101/GFX_00201/GFX_00301
//            fileBean.setFileType(fileType);
//            fileBean.setMainFlag("M");
//            fileBean.setSideFlag("F");
//            // 设置fileList
//
//            fileList.add(fileBean);
//        }
//        return fileList;
//    }
//    /**
//     * 枚举类型传入持久化类型以及返回的结果类型
//     *
//     * @param multipartFile
//     * @param persistenceType
//     * @param returnType
//     * @param businessFilePath
//     * @return
//     * @throws UploadImageException
//     */
//    public Object persistenceFile(MultipartFile multipartFile, PersistenceType persistenceType, ReturnType returnType,
//                                  String businessFilePath) throws UploadImageException {
//        String savePath = fileUploadProperties.getSavePath();
//        if (StringUtils.isEmpty(savePath)) {
//            throw new UploadImageException(ErrorType.UIMG003);
//        }
//        File firstFolder = null;
//        if (StringUtils.isEmpty(businessFilePath)) {
//            firstFolder = new File(savePath);
//        } else {
//            firstFolder = new File(savePath + businessFilePath);
//        }
//        if (!firstFolder.exists()) {
//            if (!firstFolder.mkdirs()) {
//                throw new UploadImageException(ErrorType.UIMG004);
//            }
//        }
//        String fileName = getFileNameByPersistenceType(multipartFile, persistenceType);
//        if (StringUtils.isEmpty(fileName)) {
//            throw new UploadImageException(ErrorType.UIMG005);
//        }
//        File targetFile = new File(firstFolder, fileName);
//        try {
//            multipartFile.transferTo(targetFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new UploadImageException(ErrorType.UIMG002, e);
//        }
//
//        Object resultData = null;
//        try {
//            resultData = getObjectByReturnType(multipartFile, targetFile, returnType);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new UploadImageException(ErrorType.UIMG002, e);
//        }
//        return resultData;
//    }
//    /**
//     * 封装影像上传参数
//     *
//     * @param prdCode
//     * @param serno
//     * @param fileType
//     * @return
//     * @throws ParseException
//     */
//    public Map<String, String> buildParamMap(String prdCode, String serno, String fileType) throws ParseException {
//        Map<String, String> param = new HashMap<String, String>(10);
//        // 批扫标识
//        param.put("BatchFlag", "0");
//        // 系统编号
//        param.put("SysCode", "XBSYS");
//        // 功能编号 GFX是否是变量？？？
//        param.put("FunCode", prdCode);
//        // 机构编号
//        param.put("OrgCode", "15010100");
//        // 操作人
//        param.put("OperCode", "xwadmin");
//        // 业务流水号（唯一）
//        param.put("FlwCode", serno);
//        // 业务流水号（唯一）
//        param.put("MainDocument", serno);
//        // 扫描日期，注意时间格式
//        param.put("ScanTime", DateUtils.getNowTime());
//        param.put("AttachedDocument", "0");
//        // 分支机构号
//        param.put("BranchCode", "");
//        // 网点号
//        param.put("WdCode", "");
//        // 文件目录
//        param.put("ImageType", fileType);
//        return param;
//    }
//    /**
//     * 上传到影像系统，并删除本地文件，其中包括重试
//     *
//     * @param fileList
//     * @param param
//     * @param retryTimes
//     * @param deleteLocalFiles
//     * @return
//     * @throws UploadImageException
//     */
//    public String uploadImgToImageSystem(List<FileBean> fileList, Map<String, String> param, int retryTimes,
//                                         boolean deleteLocalFiles) throws UploadImageException {
//        if (retryTimes > UploadFileConstant.MAX_RETRY_TIMES) {
//            retryTimes = UploadFileConstant.DEFAULT_RETRY_TIMES;
//        }
//        String fileImageIds = uploadImgToImageSystem(fileList, param, retryTimes);
//        if (deleteLocalFiles) {
//            for (FileBean fileBean : fileList) {
//                if (fileBean != null) {
//                    // 为了保证删除的是具体的文件，而非目录需要
//                    if (fileBean.getImgFile() != null && !fileBean.getImgFile().isDirectory()) {
//                        FileUtils.deleteQuietly(fileBean.getImgFile());
//                    } else if (!StringUtils.isEmpty(fileBean.getFilePath())) {
//                        File file = new File(fileBean.getFilePath());
//                        if (!file.isDirectory()) {
//                            FileUtils.deleteQuietly(file);
//                        }
//                    }
//
//                }
//            }
//        }
//        return fileImageIds;
//    }
//
//    /**
//     * @param multipartFile
//     * @param type
//     * @return
//     */
//    private String getFileNameByPersistenceType(MultipartFile multipartFile, PersistenceType type) {
//        switch (type) {
//            case UUID_NAME:
//                return UUID.randomUUID().toString().replaceAll("-", "") + getSuffix(multipartFile);
//            case ORIGINAL_NAME:
//                return multipartFile.getOriginalFilename();
//            default:
//                return UUID.randomUUID().toString().replaceAll("-", "") + getSuffix(multipartFile);
//        }
//
//    }
//
//    public static String getSuffix(MultipartFile multipartFile) {
//        String fileName = multipartFile.getOriginalFilename();
//        String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
//        return suffix;
//    }
//
//    /**
//     * 根据传入的
//     *
//     * @param multipartFile
//     * @param type
//     * @return
//     * @throws IOException
//     */
//    private Object getObjectByReturnType(MultipartFile multipartFile, File targetFile, ReturnType type)
//        throws IOException {
//        switch (type) {
//            case CANONICAL_PATH:
//                return targetFile.getCanonicalPath();
//            case DOWNLOAD_URL:
//                return fileUploadProperties.getDownloadUrl() + UploadFileUtils.getEncStr(targetFile.getCanonicalPath());
//            case INPUT_STREAM:
//                return multipartFile.getInputStream();
//            case FILE:
//                return targetFile;
//            default:
//                return targetFile;
//        }
//
//    }
//
//    /**
//     * 递归调用上传，包含重试次数
//     *
//     * @param fileList
//     *            由业务自己封装,是取自mutipart还是查询于数据库
//     * @param param
//     * @param retryTimes
//     *            重试次数
//     * @return
//     * @throws UploadImageException
//     */
//    public String uploadImgToImageSystem(List<FileBean> fileList, Map<String, String> param, int retryTimes)
//        throws UploadImageException {
//
//        FileUpload fileUpload = new FileUpload(fileUploadProperties.getImgUrl(), fileUploadProperties.getFileUrl());
//        String fileImageIds = null;
//        try {
//            fileImageIds = fileUpload.UpladFiles(fileList, param);
//        } catch (Exception e) {
//            logger.error("上传到影像系统出错，重试开始", e);
//            if (retryTimes >= UploadFileConstant.ONE_TIMES) {
//                retryTimes--;
//                fileImageIds = uploadImgToImageSystem(fileList, param, retryTimes);
//            } else {
//                throw new UploadImageException(ErrorType.UIMG006, e);
//            }
//        }
//
//        return fileImageIds;
//    }
//}
