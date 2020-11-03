/**
 * projectName: vhr
 * fileName: send.java
 * packageName: org.javaboy.mailserver.myrabbitmq.DirectExchange
 * date: 2020-01-17 14:23
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.myrabbitmq.DirectExchange;

//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import org.javaboy.mailserver.myrabbitmq.ConnectionUtil;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: send
 * @packageName: org.javaboy.mailserver.myrabbitmq.DirectExchange
 * @description: 发送者
 * @data: 2020-01-17 14:23
 **/
/*public class send {
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");

        // 消息内容
        for(int i=0; i<100;++i) {
            String message = "删除商品-------->"+i;
            channel.basicPublish(EXCHANGE_NAME, "delete", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}*/
