package codeWars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WhichAreIn {

	public static void main(String... args) {
		String[] array1 = { "strong", "arp", "live" };
		String[] array2 = { "lively", "alive", "harp", "sharp", "armstrong" };

		//inArray(array1, array2);
		
        int i = 0; 
        //i += i++; 
        i+=i++ + ++i;
        System.out.println(i); 
	}

	public static String[] inArray(String[] array1, String[] array2) {
		Set<String> resultSet = new HashSet<>();

		for (String str1 : array1) {
			for (String str2 : array2) {
				if (str2.contains(str1)) {
					resultSet.add(str1);
				}
			}
		}
		String[] resultList = resultSet.toArray(new String[resultSet.size()]);
		Arrays.sort(resultList);
		Arrays.stream(resultList).forEach(p -> System.out.println(p));
		return resultList;

		/*
		 * Arrays.sort(array1); Arrays.sort(array2); List<String> presentInArraySecond =
		 * new ArrayList<>(); for (int i = 0; i < array1.length; i++) { for(int j = 0; j
		 * < array2.length; j++) {
		 * 
		 * if(array2[j].contains(array1[i])) { presentInArraySecond.add(array1[i]);
		 * break; } } } presentInArraySecond.forEach(p -> System.out.println(p)); return
		 * presentInArraySecond.toArray(new String[presentInArraySecond.size()]);
		 */

		// return stream(array1).filter(s1 -> stream(array2).anyMatch(s2 ->
		// s2.contains(s1))).sorted().distinct().toArray(String[]::new);

	}
}
