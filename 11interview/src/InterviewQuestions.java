import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author olena.viliuzhanina
 *
 */
public class InterviewQuestions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*Animal.Dog nestedNonStatic = new Animal().new Dog();
		nestedNonStatic.foo();
		Animal.Horse nestedStatic = new Animal.Horse();
		
		
		
		List<String> list = new ArrayList<String>();
		list.add("qqqqq");
		list.add("eeee");
		list.add("rrrrr");
		list.add("vvvvv");
		ListIterator<String> iterator = list.listIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next()); 
		}

		
		int[] arr = new int[] { 6, 0, 9, 5, 2 };
		int[] arr1 = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr1[i] = arr[arr.length - 1 - i];
		}

		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

		String s = "name";
		Map<String, Integer> phoneBook = new HashMap<>();
		
		phoneBook.put("name", new Integer(847));
		if (!phoneBook.containsKey(s)) {
			phoneBook.put("name", new Integer(847));
		}

		phoneBook.entrySet().forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));

		solve(5, 6, 7, 3, 6, 10);
		
		List<String> list111 = new ArrayList<>();
	
		
		long[] ar = new long[] {}; 
		//aVeryBigSum(int n, long[] ar); */

		//Map, Entry, EntrySet
		
		Map<String, String> myMap = new HashMap<String, String>();
	
		myMap.put("One", "1");
		myMap.put("One", "2");
		myMap.put("One", "3");
		myMap.put("One1", "4");
		
		for(Map.Entry<String, String> value: myMap.entrySet()) {
			System.out.println(myMap.entrySet().size());
			System.out.println(value.getValue() + " " + value.getKey()); 
		}
		
		for(String key: myMap.keySet()) {
			System.out.println(key);
		}
		
		Iterator<Map.Entry<String, String>> iterator = myMap.entrySet().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next()); 
		}

		
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		
		// Animal animal = new Cat();
		// animal.foo();

		// for(int i = 0; i < 24; i++) {
		// int j = i % 4;
		// if(j != 0) {
		// System.out.println("i = " + i);
		// }
		// }

		// boolean b = false;
		// if(b = true) {
		// System.out.println("Hello");
		// }

		// test();

		// System.out.println(cutSticks(lengths));
		// int [] first = new int[] {6,5,0,4,-1,2};
		// int [] second = new int[] {5,0,6,7,3,9};
		//
		// System.out.println(Arrays.toString(sortedArray(first, second)));
	}

	static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2) {
		int alicePoints = 0;
		int bobPoints = 0;

		alicePoints = ((a0 > b0) ? 1 : 0) + ((a1 > b1) ? 1 : 0) + ((a2 > b2) ? 1 : 0);
		bobPoints = ((a0 < b0) ? 1 : 0) + ((a1 < b1) ? 1 : 0) + ((a2 < b2) ? 1 : 0);
		int[] result = new int[] { alicePoints, bobPoints };

		System.out.println(result[0] + " " + result[1]);
		return result;

	}
	
	static long aVeryBigSum(int n, long[] ar) {
        long sumLong = Arrays.stream(ar).sum();
        return sumLong + (long)n;
    }

	private static int test() {
		try {
			System.out.println("1");
			return 1;
		} finally {
			System.out.println("2");
			return 2;
		}
	}

	static int[] cutSticks(int[] lengths) {
		int minValue = lengths[0];
		int[] array = lengths;
		List<Integer> denotesNumbers = new ArrayList<Integer>();

		for (int j = 0; j < lengths.length; j++) {
			if (lengths[j] <= 1) {
				break;
			}

			for (int i = 0; i < lengths.length; i++) {
				if (minValue > 0 && lengths[i] < minValue) {
					minValue = lengths[i];
				}
			}

			for (int i = 0; i < lengths.length; i++) {
				if (lengths[i] > 0) {
					array[i] = lengths[i] - minValue;

				}
			}

			int maxValue = 0;

			for (int i = 0; i < lengths.length; i++) {
				if (lengths[i] > maxValue) {
					maxValue = lengths[i];
				}
			}

			denotesNumbers.add(maxValue);
			maxValue = 0;
		}

		int[] rv = new int[denotesNumbers.size()];
		for (int i = 0; i < denotesNumbers.size(); i++) {
			rv[i] = denotesNumbers.get(i);
			System.out.println(rv[i]);
		}

		return rv;
	}

	public static int[] sortedArray(int[]... arrays) {
		int length = 0;
		for (int[] array : arrays) {
			length += array.length;
		}

		int[] result = new int[length];

		int offset = 0;
		for (int[] array : arrays) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		Arrays.sort(result);

		return result;
	}

}
