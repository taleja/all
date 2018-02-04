package classLoader;

import java.io.File;

import test.TestClass;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		MyClassLoader myClassLoader = new MyClassLoader(new File ("C:\\Users\\elena\\OneDrive"
				+ "\\Documents\\projects\\all\\classLoader\\target\\classes\\test"));
		
		Class testClass = myClassLoader.loadClass("test.TestClass");
		Object obj = testClass.newInstance();
		System.out.println(obj.toString()); 
//		TestClass tc = (TestClass) obj; 
		
		System.out.println(obj.getClass() == TestClass.class); 
	}
}
