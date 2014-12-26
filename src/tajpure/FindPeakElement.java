package tajpure;

public class FindPeakElement {

	public static int findPeakElement(int[] num) {
		int begin = 0;
		int end = num.length - 1;
		while (begin < end) {
			int mid = (begin + end + 1) / 2;
			if (mid == 0 || num[mid-1] < num[mid]) {
				begin = mid;
			} else {
				end = mid - 1;
			}
		}
		return begin;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,1,2,3,4};
		System.out.println(findPeakElement(num));
	}
}
