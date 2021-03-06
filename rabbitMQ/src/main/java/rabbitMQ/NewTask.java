package rabbitMQ;

import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask {

	
	private static final String TASK_QUEUE_NAME = "task_queue";
	
	public static void main(String [] args) throws Exception, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection(); 
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		String message = getMessage(args);
		
		channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
		System.out.println("[x] Sent '" + message + "'");
		
		channel.close();
		connection.close();
		
	}

	private static String getMessage(String[] strings) {
		if(strings.length < 1) {
			return "Hello, World!";
		}
		return joinsString(strings, " ");
	}

	private static String joinsString(String[] strings, String delimeter) {
		int length = strings.length;
		if(length == 0) {
			return "";
		}
		StringBuilder words = new StringBuilder(strings[0]);
		for(int i = 0; i < words.length(); i++) {
			words.append(delimeter).append(strings[i]);
		}
		return words.toString();
	}
}
