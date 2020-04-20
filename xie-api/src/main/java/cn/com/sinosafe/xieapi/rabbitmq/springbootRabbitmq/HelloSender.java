/**
 * projectName: vhr
 * fileName: HelloSender.java
 * packageName: org.javaboy.mailserver.springbootRabbitmq
 * date: 2020-01-17 16:25
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.springbootRabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: HelloSender
 * @packageName: org.javaboy.mailserver.springbootRabbitmq
 * @description: 生产者
 * @data: 2020-01-17 16:25
 **/
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void sennd(){
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        String context = "hello " + date;
        System.out.println("Sender : " + context);
        //简单对列的情况下routingKey即为Q名
        rabbitmqTemplate.convertAndSend("q_hello",context);
    }
}
