package tajpure;

/**
 * Be careful of substring() function.
 * @author taojx
 *
 */
public class LongestPalindromicSubstring {
	
	// O(1)
	public static String longestPalindrome(String s) {
		
		return "";
	}
	
	// O(2)
	public static String longestPalindromeI(String s) {
		if(s == null || s.length() <= 1) {
	        return s;
	    }
	    int len = s.length();
	    int start = 0, end = 0;
	    boolean[][] palindrome = new boolean[len][len];
	    for(int i=0;i<len;i++) {
	        palindrome[i][i] = true;
	    }
	    for(int i=1;i<len;i++) {
	        if(s.charAt(i-1) == s.charAt(i)) {
	            palindrome[i-1][i] = true;
	            start = i-1; end = i+1;
	        }
	    }
	    for(int k=2;k<len;k++) {
	        for(int i=0;i+k<len;i++) {
	            int j = i+k;
	            if(s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]) {
	                palindrome[i][j] = true;
	                start = i; end = j+1;
	            }
	        }
	    }
	    return s.substring(start, end);
	}
	
	// O(3)
	public static String longestPalindromeII(String s) {
		int length = s.length();
		int maxLen = 0;
		int start = 0, end = 0;
        for (int i = 0; i < length; i++) 
        	for (int j = i; j <= length; j++) {
        		int subLen = j - i;
        		if (isPalindrome(s, i, j)) {
        			if (maxLen < subLen) {
            			maxLen = subLen;
        				start = i;
        				end = j;
        			}
        		}
        	}
		return s.substring(start, end);
    }
	
	public static boolean isPalindrome(String s, int begin, int end) {
		int length = end - begin;
		for (int i = begin; i < length / 2; i++) {
			if (s.charAt(i) != s.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "bananas";//teaeteaet
		System.out.println(longestPalindromeI(s));
	}
}
