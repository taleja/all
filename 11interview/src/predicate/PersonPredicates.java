package predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author olena.viliuzhanina
 *
 */
public class PersonPredicates {
	
	public static Predicate<Person> isAdultFemale(){
		return p -> p.getAge() > 21 && p.getGender() == "F";
	}

	public static Predicate<Person> isAdultMale(){
		return p -> p.getAge() > 21 && p.getGender() == "M";
	}
	
	public static Predicate<Person> isAgeMoreThan(int age){
		return p -> p.getAge() > age;
	}
	
	public static List<Person> filterPersons(List<Person> personsList, Predicate<Person> predicate){
		return personsList.stream().filter(predicate).collect(Collectors.toList());
	}
}
