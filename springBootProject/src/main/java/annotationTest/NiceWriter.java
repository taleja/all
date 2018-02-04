package annotationTest;

import org.springframework.stereotype.Service;

@Service
public class NiceWriter implements IWriter{

	@Override
	public void writer(String str) {
		System.out.println("The string is " + str);
 	}

}
