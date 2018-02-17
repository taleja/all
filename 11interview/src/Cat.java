
/**
 * @author olena.viliuzhanina
 *
 */
public class Cat extends Animal{


	@Override
	public void foo() throws IllegalArgumentException {
		System.out.println("Cat"); 
		super.foo();
	}

	
}
