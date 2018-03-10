import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import predicate.Person;

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
		}).start();
		
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
		Arrays.sort(employes, Employee::compareByName); // This is method reference
		System.out.println("After sorting: " + Arrays.toString(employes)); 
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		 Person p1 = new Person("Anna", "Doe", 13, "F");
		 Person p2 = new Person("Olena", "Viliuzhanina", 35, "F");
		 Person p3 = new Person("Inna", "Stone", 21, "F");
		 Person p4 = new Person("Maria", "Bradley", 56, "F");
		 Person p5 = new Person("Daryna", "London", 10, "F");
		 Person p6 = new Person("Denys", "Viliuzhanin", 32, "M");
		 Person p7 = new Person("Jack", "Smith", 40, "M");
		 Person p8 = new Person("Bob", "Evansson", 9, "M");
		 Person p9 = new Person("Pat", "MacJordan", 34, "M");
		 Person p10 = new Person("Ian", "J.P.", 56, "M");
		 
		 List<Person> personsList = new ArrayList<>();
		 personsList.addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
		 System.out.println("++++++++++++++++++++");
		 personsList.stream().filter(p -> p instanceof Person).forEach(System.out::println); 
		 System.out.println("++++++++++++++++++++");
//		 personsList.stream().map(p -> p.getFirstName().toUpperCase()).forEach(System.out::println);

		 personsList.stream().sorted().map(p -> p.getFirstName()).forEach(System.out::println); 
		 
		 List<String> toUpperCase = personsList.stream().sorted().map(p -> p.getFirstName().toUpperCase()).collect(Collectors.toList());
		 System.out.println(toUpperCase); 
		 
		 boolean anyMatch =  personsList.stream().anyMatch(p -> p.getFirstName().startsWith("O"));
		 System.out.println(anyMatch); 
		 
		 Person firsrtMatchedName = personsList.stream().filter(p -> p.getFirstName().startsWith("O")).findFirst().get();  
		 System.out.println(firsrtMatchedName); 
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
