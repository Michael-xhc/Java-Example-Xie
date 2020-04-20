/**
 * projectName: vhr
 * fileName: Recv2.java
 * packageName: org.javaboy.mailserver.myrabbitmq.DualConsumer
 * date: 2020-01-16 15:01
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.myrabbitmq.DualConsumer;

//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.QueueingConsumer;
//import org.javaboy.mailserver.myrabbitmq.ConnectionUtil;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: Recv2
 * @packageName: org.javaboy.mailserver.myrabbitmq.DualConsumer
 * @description: 消费者2
 * @data: 2020-01-16 15:01
 **/
//public class Recv2 {
//    private final static String QUEUE_NAME = "test_queue_work";
//
//    public static void main(String[] argv) throws Exception {
//
//        // 获取到连接以及mq通道
//        Connection connection = ConnectionUtil.getConnection();
//        Channel channel = connection.createChannel();
//
//        // 声明队列
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//
//        // 同一时刻服务器只会发一条消息给消费者
//        //channel.basicQos(1);
//
//        // 定义队列的消费者
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//        // 监听队列，false表示手动返回完成状态，true表示自动
//        channel.basicConsume(QUEUE_NAME, true, consumer);
//
//        // 获取消息
//        while (true) {
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String message = new String(delivery.getBody());
//            System.out.println(" [x] Received 2 '" + message + "'");
//            // 休眠1秒
//            Thread.sleep(1000);
//            //下面这行注释掉表示使用自动确认模式
//            //channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
//        }
//    }
//}
