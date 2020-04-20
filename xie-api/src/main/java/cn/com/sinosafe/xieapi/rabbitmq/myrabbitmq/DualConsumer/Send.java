/**
 * projectName: vhr
 * fileName: Send.java
 * packageName: org.javaboy.mailserver.myrabbitmq.DualConsumer
 * date: 2020-01-16 15:02
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.myrabbitmq.DualConsumer;

//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import org.javaboy.mailserver.myrabbitmq.ConnectionUtil;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: Send
 * @packageName: org.javaboy.mailserver.myrabbitmq.DualConsumer
 * @description: 发送者
 * @data: 2020-01-16 15:02
 **/
//public class Send {
//    private final static String QUEUE_NAME = "test_queue_work";
//
//    public static void main(String[] argv) throws Exception {
//        // 获取到连接以及mq通道
//        Connection connection = ConnectionUtil.getConnection();
//        Channel channel = connection.createChannel();
//
//        // 声明队列
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//
//        for (int i = 0; i < 100; i++) {
//            // 消息内容
//            String message = "rabbitmq测试" + i;
//            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//            System.out.println(" [x] Sent '" + message + "'");
//
//            Thread.sleep(i * 10);
//        }
//
//        channel.close();
//        connection.close();
//    }
//}
