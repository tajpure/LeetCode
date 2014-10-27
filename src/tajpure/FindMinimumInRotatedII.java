package tajpure;

public class FindMinimumInRotatedII {
	public static int findMin(int[] num) {
		int head = 0;
		int tail = num.length - 1;
		if (tail < 0) return 0;
		while (tail > head) {
			if (num[head] < num[tail]) {
				return num[head];
			}
			int mid = (head + tail) / 2;
			if (num[mid] == num[head] && num[tail] == num[mid]) {
					head++;
					tail--;
			} else if (num[mid] >= num[head]) {
				head = mid + 1;
			} else {
				tail = mid;
			}
		}
		return num[tail];
	}
	 
	public static void main(String[] args) {
		int[] arr = {2,3,4,0,1,1};
		System.out.println(findMin(arr));
	}
}
