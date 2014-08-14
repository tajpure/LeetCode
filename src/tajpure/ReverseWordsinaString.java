package tajpure;
/**
 *
 * @author taojx
 */
public class ReverseWordsinaString {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String result = null;
        s = s.trim();
        String[] substr = s.split(" ");
        
        int n = substr.length;
        result = substr[--n];
        while (n-- != 0) {
        	if (substr[n].length() != 0)
        	result += " " + substr[n];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	System.out.println(reverseWords("the sky is blue"));
    }
}
