package tajpure;

import java.util.Stack;

/**
 *
 * @author taojx
 */
public class EvaluateReversePolishNotation {
	
	 public static int evalRPN(String[] tokens) {
	    	int value = 0;
	    	int temp  = 0;
	    	Stack<Integer> stack = new Stack<Integer>(); 
	    	for (String str : tokens) {
	    		switch (str) {
    			case "+" : value = stack.pop() + stack.pop(); break;
    			case "-" : temp = stack.pop(); value = stack.pop() - temp; break;
    			case "*" : value = stack.pop() * stack.pop(); break;
    			case "/" : temp = stack.pop(); value = stack.pop() / temp; break;
    			default : value = Integer.parseInt(str); break;
    			}
	    		stack.push(value);
	    	}
	        return stack.pop();
	    }
	    
	    public static void main(String[] args) {
	    	//System.out.println(reverseWords("the sky is blue"));
	    	String[] tokens = {"2", "1", "+", "3", "*"};
	    	System.out.println(evalRPN(tokens));
	    }
}
