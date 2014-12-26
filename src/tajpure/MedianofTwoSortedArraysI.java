package tajpure;

public class MedianofTwoSortedArraysI {
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		return medianSearch(A, B, Math.max(1, (m+n)/2-n), Math.min(m, (m+n)/2));
	}
	
	public static double medianSearch(int A[], int B[], int left, int right) {
		int m = A.length;
		int n = B.length;
		System.out.println("l "+left+" r "+right);
		if (left > right) return medianSearch(B, A, Math.max(1, (m+n)/2-m), Math.min(n, (m+n)/2));
		int i = (left+right)/2;
		int j = (m+n)/2-i;
		System.out.println("i "+i+" j "+j);
		System.out.println("A[i] "+A[i]+" B[j] "+B[j]);
		if ((j == 0 || A[i] > B[j]) && (j == n || A[i] <= B[j+1])) {
//			if (((m+n)&1) == 1) return A[i];
			return A[i];
//			else {return (A[i]+Math.min(A[i+1], B[j]))/2.0;}
		} else if((j == 0 || A[i] > B[j]) && j != n && A[i] > B[j+1]) {
			return medianSearch(A, B, left, i-1);
		} else {
			return medianSearch(A, B, i+1, right);
		}
	}
	
	public static void main(String[] args) {
		int[] A = {2,4,6,32,38};
		int[] B = {1,2,3,4};
		System.out.println(findMedianSortedArrays(A, B));
	}
}
