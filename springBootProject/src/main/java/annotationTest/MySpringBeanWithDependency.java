package annotationTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySpringBeanWithDependency {

	private IWriter writer;

	public IWriter getWriter() {
		return writer;
	}

	@Autowired
	public void setWriter(IWriter writer) {
		this.writer = writer;
	}
	
	public void run() {
		String s = "This is my Test";
		writer.writer(s); 
	}
	
}
