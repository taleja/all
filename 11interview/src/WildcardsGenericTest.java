import java.util.ArrayList;
import java.util.List;

/**
 * @author olena.viliuzhanina
 *
 */
public class WildcardsGenericTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<>();
		List<? extends Number> numbList = new ArrayList<>();
		
		numbList = intList;
		
		//numbList.add(new Integer(5));

	}

}

