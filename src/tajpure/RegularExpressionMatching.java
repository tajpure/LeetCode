package tajpure;

public class RegularExpressionMatching {
	
	public boolean isMatch(String s, String p) {
		int lenOfS = s.length();
		int lenOfP = p.length();
		int i, j;
		for (i = 0, j = 0; i < lenOfS && j < lenOfP; i++, j++) {
			if (p.charAt(i) == '.') {
				i++;
				j++;
			} else if (p.charAt(i) == '*') {
				
			} else if (p.charAt(j) == s.charAt(i)) {
				
			} else {
				return false;
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		
	}

}
