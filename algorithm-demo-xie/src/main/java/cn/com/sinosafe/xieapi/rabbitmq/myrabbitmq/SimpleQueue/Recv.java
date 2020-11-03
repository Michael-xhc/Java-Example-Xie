/**
 * projectName: vhr
 * fileName: Recv.java
 * packageName: org.javaboy.mailserver.myrabbitmq
 * date: 2020-01-16 13:14
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.myrabbitmq.SimpleQueue;

//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.QueueingConsumer;
//import jdk.nashorn.internal.objects.annotations.Where;
//import org.javaboy.mailserver.myrabbitmq.ConnectionUtil;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: Recv
 * @packageName: org.javaboy.mailserver.myrabbitmq
 * @description: 消费者
 * @data: 2020-01-16 13:14
 **/
/*public class Recv {
    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] args) throws Exception{
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列
        channel.basicConsume(QUEUE_NAME,true,consumer);

        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("接收信息："+message);
        }
    }
}*/
