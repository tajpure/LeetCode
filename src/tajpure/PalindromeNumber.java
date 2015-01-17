package tajpure;

public class PalindromeNumber {
	
	public static boolean isPalindrome(int x) {
		return reverse(x) == x ? true : false;
    }
	
	public static int reverse(int x) {
		int result = 0;
		x = x > 0 ? x : - x;
		for (int i = x; ; i = i / 10) {
			int remainder = i % 10;
			if (result > (Integer.MAX_VALUE / 10.0) - (remainder / 10.0) || result < 0) {
				return 0; // overflow
			}
			result = remainder + result * 10;
			if (i / 10 == 0) break;
		}
		return result;
    }
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(-2147447412));
	}
}
