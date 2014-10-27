package tajpure;

/**
 * author: tajpure
 */
public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] num) {
        int head = 0;
        int tail = num.length - 1;
        while (tail >= head) {
            if (num[head] < num[tail]) {
                return num[head];
            }
            int mid = (head + tail) / 2;
            if (num[mid] >= num[head]) {
                head = mid + 1;
            } else {
                tail = mid;
            }
        }
        return num[head];
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findMin(arr));
    }
}
