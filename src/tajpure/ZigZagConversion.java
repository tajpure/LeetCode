package tajpure;

/**
 * time : O(n), memory : O(1)
 * @###############@############ <- The first row
 * #@#############@#@##########
 * ##@###########@###@#########  The upper part
 * ###@#########@#####@########
 * ####@#######@#######@####### <- The mid row
 * #####@#####@#########@######
 * ######@###@###########@#####  The lower part
 * #######@#@#############@####
 * ########@################@### <- The last row
 * @author tajpure
 *
 */
public class ZigZagConversion {
	
	public static String convert(String s, int nRows) {
		if (nRows == 1) return s;
		int length = s.length();
		StringBuilder result = new StringBuilder("");
		// To judge the length of the current step
    	boolean isShortInterval;
    	
        for (int i = 0; i < nRows; i++) {
        	int step = Math.max((nRows - i - 1) * 2, i * 2);
        	// The step of the upper part(1~nRows/2) should be started with long,
        	// The step of the lower part(nRows/2+1~nRows) should be started with short. 
        	isShortInterval = i < nRows / 2 ? false : true;
        	for (int j = i; j < length;) {
        		result.append(s.charAt(j));
        		// All the step length of the first and last rows is same.
            	if (isShortInterval && i !=0 && i != nRows-1) {	
            		 // The short step.
            		 j = (nRows - 1) * 2 - step + j;
            		 isShortInterval = false; // The next step should be long
            	} else {
            		// The long step
            		j = step + j;
            		if (i !=0 && i != nRows-1) {
            			isShortInterval = true; // The next step should be short
            		}
            	}
        	}
        }
        
		return result.toString();
    }
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING"; // PAHNAPLSIIGYIR
		System.out.println(convert(s, 3));
	}
}
