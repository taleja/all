package com.javaworld.sample.helloservice;

/**
 * @author olena.viliuzhanina
 *
 */
public class HelloServiceImpl implements HelloService{

	@Override
	public String sayHello() {
		System.out.println("Inside HelloServiceImple.sayHello()");
		return "Say Hello"; 
	}

}
