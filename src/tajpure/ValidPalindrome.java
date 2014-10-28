package tajpure;

import java.util.Stack;


public class ValidPalindrome {
	
	public static boolean isPalindrome(String s) {
        boolean result = true;
        Stack<Character> stack = new Stack<Character>();
        
        s = getAlphanumeric(s);
        int length = s.length();
        int mid = length/2;
        for (int i = 0; i < mid; i++) {
        	stack.push(s.charAt(i));
        }

    	if (length%2 != 0) {
    		mid = mid + 1;
    	}
    	
        for (int i = 0; i < length/2; i++) {
        	if (stack.pop() != s.charAt(i + mid)) {
        		result = false;
        		break;
        	}
        }
        
        return result;
    }
	
	public static String getAlphanumeric(String s) { 
		s = s.toLowerCase();
		return s.replaceAll("[^a-z0-9]", "");
	}
	
	public static void main(String[] args) {
		String right = "A man, a plan, a canal: Panama";
		String error = "race a car";
		System.out.println(isPalindrome(right));
	}
}
