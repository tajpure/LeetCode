package tajpure;

import java.util.HashSet;
import java.util.Set;

/**
 * Daynamic Programming
 * @author taojx
 */
public class WordBreak {

	public static boolean wordBreak(String s, Set<String> dict) {
		int length = s.length();
		boolean[] can = new boolean[length + 1];
		can[0] = true;
		for (int i = 1; i <= length; i++) {
			for (int j = 0; j < i; j++) {
				if (can[j] && dict.contains(s.substring(j, i))) {
					can[i] = true;
					break;
				}
			}
		}
		return can[length];
	}

	public static void main(String[] args) {
		String s = "aaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaa");
		dict.add("aaaa");
		System.out.println(wordBreak(s, dict));
	}
}
