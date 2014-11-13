package tajpure;

public class SingleNumberII {
	public static int singleNumber(int[] A) {
		int one = 0;
		int two = 0;
		for (int i = 0; i < A.length; i++) {
			one = (one ^ A[i]) & ~two;
			two = (two ^ A[i]) & ~one;
		}
		return one;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,2,4,3,4,6,6,5,5,1,4,1,2,3,7,5,6};
		System.out.println(singleNumber(A));
	}
}
