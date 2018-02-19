package rabbitMQ;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.*;

public class EmitLog {

	private static final String EXCHANGE_NAME =  "logs"; 
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel  channel = connection.createChannel();
		
		channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);		
		String message = getMessage(args);	
		
		channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
		System.out.println(" [x] Sent '" + message + "'");
		
		connection.close();
		channel.close();
	}

	private static String getMessage(String[] strings) {
		if(strings.length == 0) {
			return "Hello!";
		}
		return joinStrings(strings, " ");
	}

	private static String joinStrings(String[] strings, String delimeter) {
		int length = strings.length;
		if(length == 0) {
			return "";
		}
		StringBuilder words = new StringBuilder(strings[0]);
		for(int i = 0; i < strings.length; i++) {
			words.append(strings[i]).append(delimeter);
		}
		return words.toString();
	}

}
