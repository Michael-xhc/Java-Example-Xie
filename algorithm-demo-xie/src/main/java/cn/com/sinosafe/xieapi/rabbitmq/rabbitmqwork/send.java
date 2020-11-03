/**
 * projectName: vhr
 * fileName: send.java
 * packageName: org.javaboy.mailserver.rabbitmqwork
 * date: 2020-01-19 17:39
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.rabbitmqwork;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: send
 * @packageName: org.javaboy.mailserver.rabbitmqwork
 * @description: 发送者
 * @data: 2020-01-19 17:39
 **/
public class send {

    @Autowired
//    private AmqpTemplate amqpTemplate;

    public void send1(int i){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        String context = "hello " + i + " " + date;
        System.out.println("Sender : " + context);
        //简单对列的情况下routingKey即为Q名
//        this.amqpTemplate.convertAndSend("q_hello", context);
    }
}
