import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author olena.viliuzhanina
 *
 */
public class Streams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 3, 5, 0};
		int[] runs = IntStream.range(0, arr.length).filter(i -> i == 0 || arr[i-1] > arr[i]).toArray();
		System.out.println(Arrays.toString(runs));

	}

}
