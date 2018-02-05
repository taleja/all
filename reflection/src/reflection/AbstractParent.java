package reflection;

@TestAnnotation(someValue="someValue")
public class AbstractParent <T>{

	@TestAnnotation(someValue="someValue")
	private String field;

	public AbstractParent() {}
	
	public AbstractParent(String field) {
		this.field =  field;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	public String print() {
		return "Hello, Reflection"; 
	}
	
	public void printLine(T t) {
		System.out.println("Printline" + t); 
	}
	
	public void printLine(Integer t) {
		System.out.println("Printline" + t); 
	}
}
