package cn.com.sinosafe.xiecommon.utils;

import cn.com.sinosafe.agent.common.code.AgentResponseCode;
import cn.com.sinosafe.agent.common.code.ResultCode;
import cn.com.sinosafe.lina.common.protocol.ReturnBean;
import cn.com.sinosafe.lina.common.protocol.ServiceException;

/**
 * @ClassName:  AgentJsonProtocol   
 * @Description:公共返回参数   
 * @author: HuYang
 * @date:   2020年2月11日 下午9:05:23      
 * @Copyright:
 */
public class AgentJsonProtocol {
	private int code;
    private String message;
    private Object data;
    
    public AgentJsonProtocol() {
	}
    
    public AgentJsonProtocol(int code) {
	    this.code = code;
	}
	
	public AgentJsonProtocol(int cde, String msg) {
		this.code = cde;
		this.message = msg;
	}
	
	public AgentJsonProtocol(int cde, Object data) {
	    this.code = cde;
	    this.data = data;
	}
	
	public AgentJsonProtocol(int cde,  String msg, Object data) {
		this.code = cde;
		this.message = msg;
		this.data = data;
	}

    public AgentJsonProtocol setup(int code) {
        this.code = code;
        return this;
    }
    
    public static AgentJsonProtocol setup(ResultCode resultCode) {
        return new AgentJsonProtocol(resultCode.getCode(), resultCode.getMessage());
    }

    public static AgentJsonProtocol setup(ResultCode resultCode, Object data) {
        return new AgentJsonProtocol(resultCode.getCode(), resultCode.getMessage(),data);
    }

    public static AgentJsonProtocol setup(int result, Object data) {
        return new AgentJsonProtocol(result, data);
    }

    public static AgentJsonProtocol setupAsException(Throwable e) {
        return new AgentJsonProtocol(ResultCode.SERVER_ERROR.getCode(), e.getMessage());
    }

    public static AgentJsonProtocol setupAsServiceException(ServiceException e) {
        return new AgentJsonProtocol(e.getServiceCode(), e.getMessage());
    }

    public static AgentJsonProtocol setup(@SuppressWarnings("rawtypes") ReturnBean bean) {
        return new AgentJsonProtocol(bean.getResultCode(), bean.getMessage(),bean.getEntity());
    }

    public static AgentJsonProtocol setup(int cde, String msg) {
		return new AgentJsonProtocol(cde, msg);
	}

	public static AgentJsonProtocol success() {
		return AgentJsonProtocol.setup(AgentResponseCode.SUCCESS);
	}
	
	public static AgentJsonProtocol fail() {
		return AgentJsonProtocol.setup(AgentResponseCode.FAIL);
	}
	
	public static AgentJsonProtocol failJson(String msg) {
		return AgentJsonProtocol.setup(AgentResponseCode.FAIL.getCode(),msg);
	}
	
	public static AgentJsonProtocol response(Object obj) {
		return AgentJsonProtocol.setup(AgentResponseCode.SUCCESS,obj);
	}
	
	public static AgentJsonProtocol copRsp(ResultCode reLogin) {
		return AgentJsonProtocol.setup(reLogin);
	}
	
	public long getTimestamp() {
        return System.currentTimeMillis();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
