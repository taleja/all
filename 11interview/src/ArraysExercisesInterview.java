
public class ArraysExercisesInterview {

	public static void main(String[] args) {
		int[] first = new int[] {0,3,4,7,16,28,89};
		int[] second = new int[] {0,0};
		//System.out.println(isContains(first, second));
		
		System.out.println(binarySearch(first, 4));

	}

	public static boolean isContains(int[] first, int[] second) {
		for(int i = 0; i < second.length; i++) {			
			for(int j = 0; j < first.length; j++) {
				if(second[i] == first[j]) {
					break;
				} else if(j == first.length-1 && second[i] != first[j]) {
					return false;
				} 
			}
		}
		return true;
	}
	
	public static int binarySearch(int[] sortedArray, int key){
		int index = 0;
		int lowIndex = 0;
		int hightIndex = sortedArray.length-1;
				
		while (lowIndex <= hightIndex) {
			int mid = (lowIndex + hightIndex)/2;
			if(key == sortedArray[mid]) {
				index = mid;
				break;
			} else if(sortedArray[mid] > key) {
				hightIndex = mid - 1 ;
			} else if(sortedArray[mid] < key) {
				lowIndex = mid + 1;
			}
		}		
		return index;
	} 
}
