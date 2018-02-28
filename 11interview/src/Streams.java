import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author olena.viliuzhanina
 *
 */
public class Streams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = { 1, 3, 5, 7, 9, 2, 4, 6, 3, 5, 0 };
		int[] runs = IntStream.range(0, arr.length).filter(i -> i == 0 || arr[i - 1] > arr[i]).toArray();
		System.out.println(Arrays.toString(runs));

		Stream<String> stream = Stream.of("A$B$C$".split("\\$"));
		stream.forEach(p -> System.out.println(p));
		
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		Stream<Integer> stream1 = list.stream();
		//List<Integer> integersList = stream1.filter(p -> p%2 == 0).collect(Collectors.toList());
		Integer[] integersArray = stream1.filter(p -> p%2 == 0).toArray(Integer[]::new);
		//System.out.println(integersList);
		System.out.println(integersArray);
	} 

}
