import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author olena.viliuzhanina
 *
 */
public class LambdaExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Lambda with threads
		new Thread(() -> {
			System.out.println("Hello");
		}
		).start();
		
		//Lambda with Collection
		List<String> strList = new ArrayList<String>();
		strList.add("One");
		strList.add("Two");
		
		strList.forEach(p -> {
			System.out.println(p + " Number"); 
		});
		
		//Lambda with Collection 2
		Employee[] employes = new Employee[] {
				new Employee("Olena"),
				new Employee("Denis"),
				new Employee("Ronya")
		};
		
		System.out.println("Before sorting: " + Arrays.toString(employes)); 
		Arrays.sort(employes, Employee::compareByName); // This is lambda
		System.out.println("After sorting: " + Arrays.toString(employes)); 
	}
	
	
	static class Employee{
		String name;

		public Employee(String name) {
			this.name = name;
		}
		
		public static int compareByName(Employee emp1, Employee empp2) {
			return emp1.name.compareTo(empp2.name);
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
}
