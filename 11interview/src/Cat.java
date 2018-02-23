
/**
 * @author olena.viliuzhanina
 *
 */
public class Cat extends Animal{

	private String a = "Cat_1s";

	@Override
	public void foo() throws IllegalArgumentException {
		System.out.println(a); 
//		super.foo();
	}

	
}
