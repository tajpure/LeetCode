package tajpure;

public class StringtoInteger {
	
	public static int atoi(String str) {
		if (str == null || str.length() == 0) return 0;
        int result = 0, i = 0;
        boolean isPositive = true;
        while (str.charAt(i) == ' ') {i++;} // eat whitespace
    	switch (str.charAt(i)) {
    	case '+' : i++; break;
    	case '-' : isPositive = isPositive ? false : true; i++; break;
    	}
        for (; i < str.length(); i++) {
        	int digit = str.charAt(i) - 48;
        	if (digit < 0 || digit > 9) break;
        	if (result > (Integer.MAX_VALUE / 10.0) - (digit / 10.0)) {
				return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE; // overflow
			}
        	result = result * 10 + digit;
        }
        return isPositive ? result : - result;
    }
	
	public static void main(String[] args) {
		System.out.println(atoi("     +004500"));
	}
}
