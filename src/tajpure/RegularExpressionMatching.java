package tajpure;

public class RegularExpressionMatching {
    
    int index1 = 0;
    
    int index2 = 0;
    
    String str;
    
    String pattern;
    
    public void scan() {
        if (index2 + 1 < pattern.length() && pattern.indexOf(index2 + 1) == '*') {
            scanZeroOrMore();
        } else if (str.indexOf(index1) == pattern.indexOf(index2)) {
            index1++;
            index2++;
        }
    }
    
    public void scanZeroOrMore() {
        
    }
    
    public boolean isMatch(String s, String p) {
        index1 = s.length();
        index2 = p.length();
        str = s;
        pattern = p;
        while (index1 != 0) {
            scan();
        }
        if (index1 == 0 && index2 == 0) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        RegularExpressionMatching r = new RegularExpressionMatching();
        System.out.println(r.isMatch("aa","a")); // → false
        System.out.println(r.isMatch("aa","aa")); //  → true
        System.out.println(r.isMatch("aaa","aa")); // → false
        System.out.println(r.isMatch("aa", "a*")); //  → true
        System.out.println(r.isMatch("aa", ".*")); //  → true
        System.out.println(r.isMatch("ab", ".*")); //  → true
        System.out.println(r.isMatch("aab", "c*a*b")); //  → true
    }
}
