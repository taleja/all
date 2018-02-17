package springBootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author olena.viliuzhanina
 *
 */
@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan
//@Import({LoggerConfig.class})
//@Configuration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
    }    
}
