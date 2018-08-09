import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Office {

	public static void main(String...args) {
		//Person person = null;
		//System.out.println(person.bankVault);
		//System.out.println(person.getBankVault()); 
		//char ch = (char)-122;
		//System.out.println(ch);
		
		int a = 7;
		boolean b = true;
		if (b) {
			do {
				System.out.println(a);
			} while (a > 10);
		}
		
		byte b1 = 10;
		byte b2 = 20;

		//byte sum =  b1+b2;
		Double d1 = Double.valueOf(10);
		System.out.println(d1);
		Boolean b11 = new Boolean("0");
		System.out.println(b11);
		
		Person person =new Person();
		person.Person();
		Runtime.getRuntime().gc();
		System.gc();
		
		//int [] arr = new int[22l];
		
		String[][] multiArray = new String[][] {{"A", "B"}, {"C"}, {"Jan", "Feb", null}};
		for(int i = 0; i < multiArray.length; i++){
			for(int j = 0; j < multiArray[i].length; j++) {
				System.out.println("["+ i + "]" + "["+ j +"]" + multiArray[i][j]);
			}
		}
		
		List<String> list = new ArrayList();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		for(String str: list) {
			//System.out.println(str);
		}
		System.out.println("====");
		System.out.println(list);

		 Object[] arr = list.toArray();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] + " " + i;
			System.out.println(arr[i]);
		}
		
		for(String str: list) {
			System.out.println(str);
		}
		
		LocalDate date = LocalDate.now();
		LocalTime time  = LocalTime.now();
		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("y");	
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY");	
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy MM dd");	
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("e");
		
		DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("H h m s");
		DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("'Time now:' HH mm a");
		
		System.out.println(formatter1.format(date));
		System.out.println(formatter2.format(date));
		System.out.println(formatter3.format(date));
		System.out.println(formatter4.format(date));
		System.out.println(formatter5.format(time));
		System.out.println(formatter6.format(time));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse("2018-08-07", formatter);
		System.out.println(localDate);
		
		ArrayList<Long> larr = new ArrayList<>();
		larr.add((long)10);
		
		parseDate();
		switchCaseExample();
		
		String line = "line";
		for(int i = 0; i < line.length(); i++, switchCaseExample()) {
			System.out.println(line.charAt(i));;
		}
		
		loops();
		
		int[] myArr = new int[5];
		for(int i  = 0; i < myArr.length; i++) {
			myArr[i] = i;
			if(myArr[i]%2 == 0) {
				myArr[i] = 20;
			}
		System.out.println(myArr[i]);
		}
		
		List<String> listOfStrs = new ArrayList();		
		listOfStrs.add("Hello");
		listOfStrs.add("My");
		listOfStrs.add("Life!");
		Iterator<String> iter = listOfStrs.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			iter.remove();			
		}
		
		System.out.println(listOfStrs);
		
		String[] programmers = {"Olena", "Denys", "Viktor", "Artem"};
		outer:
		for(String name: programmers) {
			//System.out.println(name);
			for(String name1: programmers) {
				if(name1.equals("Denys")) {
					continue outer;
				}
				System.out.println(name1);
			}
		}
		for(;;);
		//for(;;) {}
	} 
	
	
	
	private static void parseDate() {
		String date = LocalDateTime.parse("2018-08-08T12:33:33").format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println(date);
		
		boolean allow = false;
		if(allow = true) {
			System.out.println("allow is true");
		} else {
			System.out.println("allow is false");
		}
	}

	private static void switchCaseExample() {
		int score  = 50;
		final  int caseVL = 10;
		switch(score) {
		case caseVL:
		case 50:
		case 100:
			System.out.println("Good average!");
			break;
		}
	}
	
	private static void loops() {
		StringBuilder[] arr = {new StringBuilder("Java"), new StringBuilder("Loop")};
		for(StringBuilder val: arr){
			System.out.println(val);
		}
		for(StringBuilder val1: arr){
			val1 = new StringBuilder("Oracle");
			System.out.println(val1);
		}
		for(StringBuilder val: arr){
			System.out.println(val);
		}
	}


	public static class MyOffice{
		
	}
}
