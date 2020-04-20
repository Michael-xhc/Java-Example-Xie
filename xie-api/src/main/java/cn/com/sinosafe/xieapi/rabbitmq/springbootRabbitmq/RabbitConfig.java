/**
 * projectName: vhr
 * fileName: RabbitConfig.java
 * packageName: org.javaboy.mailserver.springbootRabbitmq
 * date: 2020-01-17 16:15
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.springbootRabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: RabbitConfig
 * @packageName: org.javaboy.mailserver.springbootRabbitmq
 * @description: 配置队列
 * @data: 2020-01-17 16:15
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("q_hello");
    }
}
