package tajpure;

/**		
 * @auther: tajpure		
*/		
		
public class MaximumSubarray {		
		
    public static int maxSubarray(int[] A) {		
        int sum = A[0];		
        int maxSum = A[0];		
        for (int i = 1; i < A.length;i++) {		
            if (sum <= 0) {		
                sum = A[i];		
            } else {		
                sum += A[i];		
            }		
            if (maxSum < sum) {		
                maxSum = sum;		
            }		
        }		
        return maxSum;		
    }		
		
    public static void main(String[] args) {		
        int[] A = {2,1,3,4,1,2,1,5,4};		
        int maxSum = maxSubarray(A);		
        System.out.println(maxSum);
    }		
}