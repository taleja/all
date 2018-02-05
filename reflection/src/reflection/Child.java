package reflection;

import java.lang.annotation.Annotation;

@MyAnnotation(name="annotation", value=2)
//@Resource(name = "foo", description = "bar")
public class Child<T> extends AbstractParent<String> implements ReflectionInterface{

	@MyAnnotation(name="annotation", value=2)
	private String str;
	@TestAnnotation(someValue="someValue")
	private Integer one;
	
	public Child() {}
	
	public Child(String str, Integer one) {
		super(str + "1");
		this.one = one;
		this.str = str;
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Integer getOne() {
		return one;
	}

	public void setOne(Integer one) {
		this.one = one;
	}

	@Override
	public void foo() {
		System.out.println("Print"); 
	}

	@Override
	public String print() {
		return "Hello from child!";
	}
	
	public Integer calculate(Integer a, Integer b) {
		return a + b;
	}
	
	public Integer calculate(int a, int b) {
		return a - b;
	}
	
	public void nothinToReturn(int a, int b) {
		System.out.println(Math.addExact(a, b));
	}
	
	public T methodWithGeneric(T t) {
		return t; 
	}

	
}
