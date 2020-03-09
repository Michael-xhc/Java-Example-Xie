package cn.com.sinosafe.xiecommon.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * face++实体类
 * 
 * @author longxiaoqiang
 * @date 2020/02/15
 */
@Component
@ConfigurationProperties(prefix = "faceid")
public class FaceID implements Serializable {

    private static final long serialVersionUID = -846560781469408164L;

    /**
     * FaceID账号key
     */
    private String apiKey;
    /**
     * FaceID账号秘钥
     */
    private String apiSecret;
    /**
     * 流程结束后跳转到客户定义的页面，必须以http或者https开头
     */
    private String returnUrl;
    /**
     * 流程结束后，FaceID会通知客户服务器，post请求到该url，必须以http或者https开头
     */
    private String notifyUrl;
    /**
     * 人脸识别获取token地址
     */
    private String faceReqUrl;
    /**
     * OCR身份证识别地址
     */
    private String ocrIdCardReqUrl;
    /**
     * OCR银行卡识别地址
     */
    private String ocrBankCardReqUrl;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getFaceReqUrl() {
        return faceReqUrl;
    }

    public void setFaceReqUrl(String faceReqUrl) {
        this.faceReqUrl = faceReqUrl;
    }

    public String getOcrIdCardReqUrl() {
        return ocrIdCardReqUrl;
    }

    public void setOcrIdCardReqUrl(String ocrIdCardReqUrl) {
        this.ocrIdCardReqUrl = ocrIdCardReqUrl;
    }

    public String getOcrBankCardReqUrl() {
        return ocrBankCardReqUrl;
    }

    public void setOcrBankCardReqUrl(String ocrBankCardReqUrl) {
        this.ocrBankCardReqUrl = ocrBankCardReqUrl;
    }
}
