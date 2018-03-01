import java.util.Arrays;

/**
 * @author olena.viliuzhanina
 *
 */
public class Component {
	
	
	public static void main(String[] args) {
		int[] array = new int[] {1,0,7,6};
		int[] newArr = arraySort(array);
		 
		for(int i = 0; i < newArr.length; i++) {
			System.out.println(newArr[i]); 
		}
	}
	
	public static int[] arraySort(int[] array) {
		for(int i = 0; i < array.length; i++) {					
			if((i+1 <= array.length-1) && array[i] > array[i+1]) {
				
				if(array[i+1] == array[i]-1) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;	
				} else {					
					System.out.println("array cannot be sorted");	
					return array;
				}
			} 
		}
		return array;
	}
}
