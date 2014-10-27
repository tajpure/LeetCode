package tajpure;

/**
 * Implements ugly, refactor later.
 * @author taojx
 *
 */
public class MaximumProductSubarray {
	
	public static int maxProduct(int[] A) {
		int max = A[0];
		int curMax = 1;
		for (int i = 0; i < A.length; i++) {
			curMax *= A[i];
			if (curMax > max) {
				max = curMax;
			}
			if (curMax == 0) {
				curMax = 1;
			}
		}
		curMax = 1;
		for (int i = A.length - 1; i >= 0; i--) {
			curMax *= A[i];
			if (curMax > max) {
				max = curMax;
			}
			if (curMax == 0) {
				curMax = 1;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = {-3,0,1,-2};
		System.out.println(maxProduct(A));
	}
}
