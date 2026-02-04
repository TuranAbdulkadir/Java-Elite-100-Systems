package Regex_Engine_From_Scratch;

public class Main {
    public static void main(String[] args) {
        System.out.println("Match 'aa', 'a*': " + isMatch("aa", "a*"));
        System.out.println("Match 'ab', '.*': " + isMatch("ab", ".*"));
        System.out.println("Match 'mississippi', 'mis*is*p*.': " + isMatch("mississippi", "mis*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        
        boolean firstMatch = (!s.isEmpty() && 
                             (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || 
                   (firstMatch && isMatch(s.substring(1), p)));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}