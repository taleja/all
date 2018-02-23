import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;
import java.util.Objects;

/**
 * @author olena.viliuzhanina
 *
 */
public class Puzzlers {

	public static void main(String... args) {
		//// 1-st puzzlers
		boolean isQuestion = false;
		System.out.println(isQuestion ? 42 : (isQuestion ? 42 : null));

		//// 2-nd puzzlers
		bitCount((short) -1);

		//// 3-d puzzlers
		System.out.println((short) Double.NEGATIVE_INFINITY);
		System.out.println((short) Double.POSITIVE_INFINITY);

		//// 4-th puzzlers
		System.out.println("Price: " + +'2' + " euro");

		/// 5-th puzzlers
		range(10, 0).forEach(System.out::println); // not working
		rangeClosed(0, 10).map(x -> 10 - x).forEach(System.out::println); // working

		// 6-th puzzlers
		compare(0.0, 0.0);
	}

	public static short bitCount(short s) {
		short bits = 0;
		while (s != 0) {
			bits += s & 1;
			s >>>= 1;
		}
		return bits;
	}

	public static void compare(double x, double y) {
		System.out.println(x == y);
		System.out.println(Objects.equals(x, y));
	}
}
