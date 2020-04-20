/**
 * projectName: vhr
 * fileName: SimpleQueue.java
 * packageName: org.javaboy.mailserver.myrabbitmq
 * date: 2020-01-16 11:35
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.myrabbitmq.SimpleQueue;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: SimpleQueue
 * @packageName: org.javaboy.mailserver.myrabbitmq
 * @description: 简单队列
 * @data: 2020-01-16 11:35
 **/
//public class send {
//    private final static String QUEUE_NAME = "q_test_01";
//
//    public static void main(String[] args) throws Exception {
//        //获取到连接以及mq通道
//        Connection connection = ConnectionUtil.getConnection();
//        // 从连接中创建通道
//        Channel channel = connection.createChannel();
//
//        // 声明（创建）队列
//        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
//
//        // 消息内容
//        String message = "Hello World!";
//        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//        System.out.println(" [x] Sent '" + message + "'");
//        //关闭通道和连接
//        channel.close();
//        connection.close();
//    }
//}
