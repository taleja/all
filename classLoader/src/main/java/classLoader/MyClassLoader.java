package classLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MyClassLoader extends ClassLoader{
	private File file;
	
	public MyClassLoader(File file) {
		super(MyClassLoader.class.getClassLoader());
		this.file = file;
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		int i = name.lastIndexOf('.');
		File newFile = new File(file, name.substring(i+1) + ".class");
		if(!newFile.exists()) {
			return super.loadClass(name);
		}
		byte[] byteCode = null;
		try {
			byteCode = Files.readAllBytes(newFile.toPath());
		} catch (IOException e) {
			throw new ClassNotFoundException();
		}
		System.out.println(name); 
		return super.defineClass(byteCode, 0, byteCode.length); 
	}
	
	
}
