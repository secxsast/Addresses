
import javax.servlet.http.*;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Recv {

    @Value("${app.awsServices.rabbitMQName1}")
    private String QUEUE_NAME_1;

    @Value("${app.awsServices.rabbitMQName2}")
    private String QUEUE_NAME_2;

    public void Receive1(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME_1, false, false, false, null);
        out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME_1, true, deliverCallback, consumerTag -> { });
    }
	
	public void Receive2(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME_2, false, false, false, null);
        out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME_2, true, deliverCallback, consumerTag -> { });
    }
}

