package com.javaworld.sample.helloservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author olena.viliuzhanina
 *
 */
public class HelloServiceActivator implements BundleActivator {
	
	ServiceRegistration<HelloService> helloServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		HelloService helloService = new HelloServiceImpl();
		helloServiceRegistration = (ServiceRegistration<HelloService>) context.registerService(HelloService.class.getName(), helloService, null);
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		helloServiceRegistration.unregister();
		
	}

}
