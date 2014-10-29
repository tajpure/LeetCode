package tajpure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Daynamic Programming, Backtracking
 * TODO For "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" this situation, always TLE,
 *  Should find a more efficient solution to solve this problem. 
 * @author taojx
 * 
 */
public class WordBreakII {

	public static List<String> wordBreak(String s, Set<String> dict) {
		int length = s.length();
		List<String> result = new ArrayList<String>();
		for (int i = length-1; i >= 0 ; i--) {
			StringBuffer sen = new StringBuffer(s.substring(i, length));
			if (dict.contains(sen.toString())) {
				if (i == 0) {
					result.add(sen.toString());
				} else {
					String tail = sen.toString();
					String remain = s.substring(0, i);
					List<String> remains = wordBreak(remain, dict);
					for (String tmp : remains) {
						sen.insert(0, " ").insert(0, tmp);
						result.add(sen.toString());
						sen.replace(0, sen.length(), tail);
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("aaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaaaaaaa");
		System.out.println(wordBreak(s, dict));
	}
}
