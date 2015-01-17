package tajpure;

/**
 * This is　my solution. I have a problem that when x = -2147483648 the result of "abs" is -2147483648.
 * The "abs" annotation : Note that if the argument is equal to the value of
 * {@link Integer#MIN_VALUE}, the most negative representable
 * {@code int} value, the result is that same value, which is
 * negative.
 * @author taojx
 *
 */
public class ReverseInteger {
	public static int reverse(int x) {
		boolean isPositive = x > 0 ? true : false;
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
		return isPositive ? result : - result;
    }
	
	public static void main(String[] args) {
		System.out.println(reverse(-2147483648)); // 2147483647
		System.out.println(Math.abs(-2147483648));
	}
}
