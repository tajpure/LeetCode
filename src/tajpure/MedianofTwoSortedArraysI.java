package tajpure;

/**
 * The basic idea is that if you are given two arrays A and B
 * and know the length of each, you can check whether an element 
 * A[i] is the median in constant time. Suppose that the median 
 * is A[i]. Since the array is sorted, it is also greater than
 * exactly j = [n/2] - (i - 1) elements in B. It requires constant
 * time to check if B[j] <= A[i] <= B[j+1}. If A[i] is not the 
 * median, then depending on whether A[i] is greater or less than 
 * B[j] and B[j+1], you know that A[i] is either greater than or 
 * less that the median.(This solution comes from MIT 6.046J / 
 * 18.410J Introduction to Algorithms)
 * @author taojx
 *
 */
public class MedianofTwoSortedArraysI {
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length, n = B.length;
		double result = 0;
		if (m > n) return findMedianSortedArrays(B, A);
		int k = (m + n - 1) / 2;
		int left = 0, right = Math.min(m, k);
		while (left < right) {
			int i = (left + right) / 2;
			int j = k - i;
			if (A[i] < B[j]) {
				left = i + 1;
			} else {
				right = i;
			}
		}
		result = Math.max(left > 0 ? A[left - 1] : Integer.MIN_VALUE, k - left >= 0 ? B[k - left] : Integer.MIN_VALUE);
		if (((m + n) & 1) == 1)  return result;
		else result = (result + Math.min(left < m ? A[left] : Integer.MAX_VALUE, k - left + 1 < n ? 
				B[k - left + 1] : Integer.MAX_VALUE)) / 2;
		return result;
	}
	
	public static void main(String[] args) {
		int[] B = {1,3};
		int[] A = {2};
		System.out.println(findMedianSortedArrays(A, B));
	}
}
