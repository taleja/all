package reflection;

public class AbstractParent <T>{

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
