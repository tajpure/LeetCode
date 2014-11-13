package tajpure;

import java.util.HashMap;
import java.util.Hashtable;


public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
		int[] index = new int[2];
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			table.put(numbers[i], i+1);
		}
		for (int i = 0; i < numbers.length; i++) {
			Integer index1 = table.get(target - numbers[i]);
			if (index1 != null && index1 != i+1) {
				if (index1 < i+1) {
					index[0] = index1;
					index[1] = i+1;
				} else {
					index[0] = i+1;
					index[1] = index1;
				}
				break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] num = {2, 7, 11, 15, 2};
		int [] index = twoSum(num, 17);
		System.out.println(index[0] + " " + index[1]);
	}
}
