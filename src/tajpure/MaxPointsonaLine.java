package tajpure;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author taojx
 */
public class MaxPointsonaLine {
	 public static int maxPoints(Point[] points) {
		 int maxNum = 1;
		 int sameNum = 0;
		 double slope = 0.0;
	     Map<Double, Integer> slopeMap = new HashMap<Double, Integer>();
	     if (points.length == 0) { return 0;};
	     for (Point a : points) {
	    	 for (Point b : points) {
	    		 if (a == b) {
	    			 continue;
	    		 } 
	    		 if (a.x == b.x && a.y == b.y) {
	    			 sameNum++;
	    			 continue;
	    		 }
	    		 slope = ((double)(a.y - b.y)) / (a.x - b.x);
	    		 if (slopeMap.get(slope) == null) {
		    		 slopeMap.put(slope, 2);
	    		 } else {
	    			 slopeMap.put(slope, slopeMap.get(slope)+1);
	    		 }
	    	 }
	    	 for (Integer value : slopeMap.values()) {
	    		 if (maxNum < value + sameNum) {
	    			 maxNum = value + sameNum;
	    		 }
	    	 }
	    	 if (slopeMap.size() == 0 && sameNum > 0) {
	    		 maxNum = sameNum + 1;
	    	 }
	    	 slopeMap.clear();
	    	 sameNum = 0;
	     }
		 return maxNum;
	 }
	 
	 public static void main(String[] args) {
		 Point[] a = {new Point(1,1),new Point(1,1),new Point(2,2),new Point(2,2)};
		 System.out.println(maxPoints(a));
	 }
}