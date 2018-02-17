import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author olena.viliuzhanina
 *
 */
public class InterviewQuestions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Cat cat = new Cat();
//		cat.foo();
		
//		for(int i = 0; i < 24; i++) {
//			int j = i % 4;
//			if(j != 0) {
//				System.out.println("i = " + i);
//			}
//		}
		
//		boolean b = false;
//		if(b = true) {
//			System.out.println("Hello"); 
//		}
		
//		test();
		
//		System.out.println(cutSticks(lengths));
		int [] first = new int[] {6,5,0,4,-1,2}; 
		int [] second = new int[] {5,0,6,7,3,9};
		
		System.out.println(Arrays.toString(sortedArray(first, second)));
	}
	
//	private static int test() {
//		try {
//			System.out.println("1");
//			return 1;
//		}finally {
//			System.out.println("2");
//			return 2;
//		}		
//	}
//	
    static int[] cutSticks(int[] lengths) {
        int minValue = lengths[0];
        int []array = lengths;
        List<Integer> denotesNumbers = new ArrayList<Integer>();

        
        for(int j = 0; j < lengths.length; j++) {
        	if(lengths[j] <= 1) {
        		break;
        	} 
        	
        	for(int i = 0; i < lengths.length; i++){
        		if(minValue > 0 && lengths[i] < minValue){
        			minValue = lengths[i]; 
        		}
        	}
        	
        	for(int i = 0; i < lengths.length; i++){
        		if(lengths[i] > 0){
        			array[i] = lengths[i] - minValue;  

        		}           
        	}
        	
        	int maxValue = 0;
       	
        	for(int i = 0; i < lengths.length; i++){
        		if(lengths[i] > maxValue){
        			maxValue = lengths[i]; 
        		}
        	}
        	
        	denotesNumbers.add(maxValue);
        	maxValue = 0;
        }
        

        int[] rv = new int[denotesNumbers.size()];
        for(int i = 0; i < denotesNumbers.size(); i++){
            rv[i] = denotesNumbers.get(i); 
            System.out.println(rv[i]);
        }
        
        return rv;
    }
    
    
    public static int [] sortedArray(int[]...arrays) {
    	int length = 0;
    	for(int[] array: arrays) {
    		length += array.length;
    	}		
    	
    	int[] result = new int[length];
    	
    	int offset = 0;
    	for(int[] array: arrays) {
    		System.arraycopy(array, 0, result, offset, array.length); 
    		offset += array.length;
    	}
    	Arrays.sort(result);
    	
    	return result;
    }
    
}
