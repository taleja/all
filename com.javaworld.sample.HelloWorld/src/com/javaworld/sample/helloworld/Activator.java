package com.javaworld.sample.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.javaworld.sample.helloservice.HelloService;

public class Activator implements BundleActivator {

	private static BundleContext context;
	ServiceReference<HelloService> helloServicereference;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Hello, World!"); 
		helloServicereference = (ServiceReference<HelloService>) context.getServiceReference(HelloService.class.getName());
		HelloService helloService = (HelloService) context.getService(helloServicereference); 
		System.out.println(helloService.sayHello()); 
	}


	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Goodye, World!"); 
		context.ungetService(helloServicereference);
	}

}
