package tajpure;

/**
 *
 * @author tajpure
 *
 */
public class ZigZagConversion {
	
	public static String convert(String s, int nRows) {
		if (nRows == 1) return s;
		int length = s.length();
		String result = "";
    	boolean top = false;
        for (int i = 0; i < nRows; i++) {
        	int step = Math.max((nRows - i - 1) * 2, i * 2);
        	top = i < nRows / 2 ? false : true;
        	for (int j = i; j < length;) {
            	result = result + s.charAt(j);
            	if (top && i !=0 && i != nRows-1) {
            		 j = (nRows - 1) * 2 - step + j;
            		 top = false;
            	} else {
            		j = step + j;
            		if (i !=0 && i != nRows-1)
           		 		top = true;
            	}
        	}
        }
		return result;
    }
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING"; // PAHNAPLSIIGYIR
		System.out.println(convert(s, 3));
	}
}
