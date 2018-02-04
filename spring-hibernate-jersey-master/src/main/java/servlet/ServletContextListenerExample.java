package servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerExample implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Kitten forever!"); 
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Hello, kitten!"); 
	}

}
