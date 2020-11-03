/**
 * projectName: vhr
 * fileName: Send.java
 * packageName: org.javaboy.mailserver.myrabbitmq.WildcardPattern
 * date: 2020-01-17 15:04
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.myrabbitmq.WildcardPattern;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: Send
 * @packageName: org.javaboy.mailserver.myrabbitmq.WildcardPattern
 * @description: 生产者
 * @data: 2020-01-17 15:04
 **/
/*public class Send {
    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        // 消息内容
        String message = "Hello World!!";
        channel.basicPublish(EXCHANGE_NAME, "routekey.1", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}*/
