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
		int m = A.length;
		int n = B.length;
		return medianSearch(A, B, Math.max(1, (m+n)/2-n), Math.min(m, (m+n)/2));
	}
	
	public static double medianSearch(int A[], int B[], int left, int right) {
		int m = A.length;
		int n = B.length;
		if (left > right) return medianSearch(B, A, Math.max(1, (m+n)/2-m), Math.min(n, (m+n)/2));
		int i = (left+right)/2;
		int j = (m+n)/2-i;
		if ((j == 0 || A[i] > B[j]) && (j == n || A[i] <= B[j+1])) {
			return A[i];
		} else if((j == 0 || A[i] > B[j]) && j != n && A[i] > B[j+1]) {
			return medianSearch(A, B, left, i-1);
		} else {
			return medianSearch(A, B, i+1, right);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {2,4,6,32,38};
		int[] B = {1,2,3,4,5};
		System.out.println(findMedianSortedArrays(A, B));
	}
}
