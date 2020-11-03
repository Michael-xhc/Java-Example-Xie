/**
 * projectName: vhr
 * fileName: Send.java
 * packageName: org.javaboy.mailserver.myrabbitmq.FanoutExchange
 * date: 2020-01-17 9:08
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.myrabbitmq.FanoutExchange;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: Send
 * @packageName: org.javaboy.mailserver.myrabbitmq.FanoutExchange
 * @description: 发送者
 * @data: 2020-01-17 9:08
 **/
/*public class Send {
    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 消息内容
        for(int i=0; i<100;++i) {
            String message = "Hello World!-------->"+i;
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}*/
