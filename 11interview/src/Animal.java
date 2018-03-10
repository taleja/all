
/**
 * @author olena.viliuzhanina
 *
 */
public class Animal {

	private String a = "Animal_1";
	
	public void foo() throws IllegalArgumentException {
		System.out.println("Animal"); 
	}
	
	public Integer add(int a, int b) {
		return a+b;
	}
	
	public Integer add(int a, float b) {
		return (int) (a+b);
	}
	
	public static void main(String[] args) {
//		Animal obj = new Dog();
//		obj.foo();
		
	}
	
	class Dog extends Animal{
		@Override
		public void foo() throws IllegalArgumentException {
			System.out.println("Wow"); 
		}
		
	}
	
	static class Horse extends Animal{
		@Override
		public void foo() throws IllegalArgumentException {
			System.out.println("Igogo"); 
		}
		
	}
}
