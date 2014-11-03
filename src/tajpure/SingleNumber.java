package tajpure;

public class SingleNumber {
	
	public static int singleNumber(int[] A) {
		int result = A[0];
		for (int i = 1; i < A.length; i++) {
			result = result ^ A[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,3,2,4,3,4,6,6,5,5,1,4};
		System.out.println(singleNumber(A));
	}
}
