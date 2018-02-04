package springBootProject;

import org.springframework.stereotype.Component;

@Component
public class LoggerService {

	public void log(String log) {
		System.out.println(log); 
	}
}
