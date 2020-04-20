/**
 * projectName: vhr
 * fileName: Recv2.java
 * packageName: org.javaboy.mailserver.myrabbitmq.DirectExchange
 * date: 2020-01-17 14:30
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.xieapi.rabbitmq.myrabbitmq.DirectExchange;

//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.QueueingConsumer;
//import org.javaboy.mailserver.myrabbitmq.ConnectionUtil;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: Recv2
 * @packageName: org.javaboy.mailserver.myrabbitmq.DirectExchange
 * @description: 消费者2
 * @data: 2020-01-17 14:30
 **/
/*public class Recv2 {
    private final static String QUEUE_NAME = "test_exchange_direct_2";
    private final static String EXCHANGE_NAME = "test_exchange_direct";

    public static void main(String[] args) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"insert");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"update");
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"delete");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME,false,consumer);

        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String massage = new String(delivery.getBody());
            System.out.println("输出信息："+massage);

            Thread.sleep(1000);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }

    }
}*/
