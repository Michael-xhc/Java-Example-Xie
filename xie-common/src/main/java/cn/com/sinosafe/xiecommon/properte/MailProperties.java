/**
 * 
 */
package cn.com.sinosafe.xiecommon.properte;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**  
* <p>Title: MailProperties</p>  
* <p>Description: 邮件配置参数</p>  
* @author longxiaoqiang  
* @date 2020年2月12日  
*/
@Component
@ConfigurationProperties(prefix = "mail")
public class MailProperties {

	/**
	 *发件人邮箱地址
	 */
	private String from;
	
	/**
	 * 发件人昵称
	 */
	private String personal;
	
	/**
	 * 异常警报接收人
	 */
	private String reciverAddress;
	
	/**
	 * 异常警报抄送人
	 */
	private String ccAddress;

	/**
	 * 邮件开关（0开1关）
	 */
	private String flag;
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPersonal() {
		return personal;
	}

	public void setPersonal(String personal) {
		this.personal = personal;
	}

	public String getReciverAddress() {
		return reciverAddress;
	}

	public void setReciverAddress(String reciverAddress) {
		this.reciverAddress = reciverAddress;
	}

	public String getCcAddress() {
		return ccAddress;
	}

	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
