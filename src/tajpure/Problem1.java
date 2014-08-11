package tajpure;

/**
 *
 * @author taojx
 * @version 创建时间：2014年8月11日 下午5:36:45
 */
public class Problem1 {
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
    
    public static int evalRPN(String[] tokens) {
    	int value = 0;
        for (int i=0; i < tokens.length; i++) {
        		if (!tokens[i].equals("")) {
        			switch (tokens[i]) {
        			case "+" : value = Integer.parseInt(tokens[i-2]) + Integer.parseInt(tokens[i-1]); break;
        			case "-" : value = Integer.parseInt(tokens[i-2]) - Integer.parseInt(tokens[i-1]); break;
        			case "*" : value = Integer.parseInt(tokens[i-2]) * Integer.parseInt(tokens[i-1]); break;
        			case "/" : value = Integer.parseInt(tokens[i-2]) / Integer.parseInt(tokens[i-1]); break;
        			}
        		}
        }
        if (tokens.length != 0) {
        	
        }
        return value;
    }
    
    public static void main(String[] args) {
    	System.out.println(reverseWords("the sky is blue"));
//    	String[] tokens = {"2", "1", "+", "3", "*"};
//    	System.out.println(evalRPN(tokens));
    }
}
