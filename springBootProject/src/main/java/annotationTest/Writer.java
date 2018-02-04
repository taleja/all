package annotationTest;

public class Writer implements IWriter{

	@Override
	public void writer(String str) {
		System.out.println(str);
	}

}
