/**
 * 
 */
package prob2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Create a generic programming solution to the problem of finding the second
 * smallest element in a list. In other words, devise a public static method
 * secondSmallest so that it can handle the biggest possible range of types.
 * 
 * @author jiang
 *
 */
public class FindInList {

	public static <T extends Comparable<? super T>> T secondSmallest(List<? extends T> list) {
		if (list.size() < 2) {
			return null;
		}
		Collections.sort(list);
		return list.get(1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Double> dList = Arrays.asList(2.3,5.9,1.2,2.1,2.0,4.8,5.7);
		Double d = secondSmallest(dList);
		System.out.println(d);
		
		List<Integer> iList = Arrays.asList(2,5,1,2,3,4,5);
		Integer i = secondSmallest(iList);
		System.out.println(i);
		
		List<String> strList = Arrays.asList("ddd", "aaa", "bbb", "ccc");
		String str = secondSmallest(strList);
		System.out.println(str);
	}

}
