package springBootProject;

import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {

//	@Bean
	public LoggerService loggerService() {
		return new LoggerService();
	}
}
