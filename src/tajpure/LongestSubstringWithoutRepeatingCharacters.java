package tajpure;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int curLen = 0;
		int preIndex = 0;
		HashMap<Character,Integer> charTable = new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			Integer curPreIndex = charTable.get(ch);
			charTable.put(ch, i);
			if (curPreIndex != null) {
				if (curLen > maxLen)
					maxLen = curLen;
				if (preIndex <= curPreIndex) {
					curLen = i - curPreIndex -1;
					preIndex = curPreIndex;
				}
			}
			curLen++;
		}
		if (curLen > maxLen)
			maxLen = curLen;
		return maxLen;
    }
	
	public static void main(String[] args) {
		String str = "hchzvfrkmlnozjk";
		System.out.println(lengthOfLongestSubstring(str));
	}
}
