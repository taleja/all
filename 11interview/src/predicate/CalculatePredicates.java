package predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author olena.viliuzhanina
 *
 */
public class CalculatePredicates {

	public static void main(String[] args) {
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
		 
//		 System.out.println(PersonPredicates.filterPersons(personsList, PersonPredicates.isAdultFemale()));
//		 System.out.println(PersonPredicates.filterPersons(personsList, PersonPredicates.isAdultMale()));
//		 System.out.println(PersonPredicates.filterPersons(personsList, PersonPredicates.isAgeMoreThan(30)));  
		 

		 //Comparator<Person> comparator = Comparator.comparing(p-> p.getFirstName());
		 //personsList.sort(comparator.reversed());
		 personsList.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName)); 
		 personsList.forEach(e -> System.out.println(e)); 

	}
	
	
}
