/**
 * projectName: vhr
 * fileName: HelloReceiver.java
 * packageName: org.javaboy.mailserver.springbootRabbitmq
 * date: 2020-01-17 17:03
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.springbootRabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: HelloReceiver
 * @packageName: org.javaboy.mailserver.springbootRabbitmq
 * @description: 消费者
 * @data: 2020-01-17 17:03
 **/
@Component
@RabbitListener(queues = "q_hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("接收信息------->" +hello);
    }
}
