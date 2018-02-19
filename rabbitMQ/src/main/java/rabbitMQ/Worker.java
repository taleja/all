package rabbitMQ;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Worker {

	private static final String TASK_QUEUE_NAME = "task_queue"; 
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		final Connection connection = factory.newConnection();
		final Channel channel = connection.createChannel();
		
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		System.out.println(" [*] Waiting for messages. To exist press CTRL+S.");
		
		channel.basicQos(1); 
		
		final DefaultConsumer deafultConsumer =  new DefaultConsumer(channel) {

			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				
				System.out.println(" [x] Received '" + message + "'");
				try {
					doWork(message);
				}finally{
					System.out.println(" [x] Done");
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}		
		};
		channel.basicConsume(TASK_QUEUE_NAME, false, deafultConsumer);
	}

	private static void doWork(String task) { 
		for(char ch: task.toCharArray()){
			if(ch == '.') {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ignored) {
					Thread.currentThread().interrupt();
				}
			}
		}		
	}
}
