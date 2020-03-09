package cn.com.sinosafe.xiecommon.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.util.Date;

/**
 * @description:  发邮件工具类
 * @author: xuhao
 * @create: 2019-03-01 18:40
 **/
@Component
public class SendEmailUtils {

    /**
     * 功能描述: <br> 发送带附件的邮件
     * @param form 发送者
     * @param to 接受者
     * @param subject 主题
     * @param content 内容
     * @param filePath 文件路径
     * @param cc 抄送人
     * @param mailSender
     * @param fileName 文件名称
     * @Return: void
     * @Author: dwj
     * @Date: 2019/8/10 12:41
     */
    public static void sendMail(String form, String to, String[] cc, String subject, String content,
                                String filePath, JavaMailSender mailSender, String fileName) throws Exception {
        MimeMessage message=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(form);
            // 设置多个抄送地址
            if(cc!=null && cc.length>0){
                helper.setCc(cc);//抄送邮件接收人
            }
            helper.setSubject(subject);
            helper.setText(content);
            helper.setSentDate(new Date());
            // 设置多个收件人地址
            if(null != to && !to.isEmpty()){
                @SuppressWarnings("static-access")
                InternetAddress[] internetAddressTo = new InternetAddress().parse(to);
                helper.setTo(internetAddressTo);
            }
            if(!StringUtils.isEmpty(filePath) && !StringUtils.isEmpty(fileName)){
                FileSystemResource file=new FileSystemResource(new File(filePath));
                //添加多个附件可以使用多条
                helper.addAttachment(MimeUtility.encodeWord(fileName),file);
            }

            mailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
