/**
 * projectName: vhr
 * fileName: HelloReceiver2.java
 * packageName: org.javaboy.mailserver.rabbitmqwork
 * date: 2020-01-19 17:38
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.rabbitmqwork;

import org.springframework.stereotype.Component;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: HelloReceiver2
 * @packageName: org.javaboy.mailserver.rabbitmqwork
 * @description: 消费者2
 * @data: 2020-01-19 17:38
 **/
@Component
//@RabbitListener(queues = "q_hello")
public class HelloReceiver2 {
//    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello);
    }
}
