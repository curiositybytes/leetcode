package dynamic_programming;

/**
 * 647. Palindromic Substrings
 *
 * @link <a href="https://leetcode.com/problems/palindromic-substrings/description/">...</a>
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    private static int countSubstrings(String s) {
        if (s.isEmpty() || s.isBlank()) return 0;

        int total = 0;

        for (int i=0; i<s.length(); ++i) {
            int countOdd = count(s, i, i);
            int countEven = count(s, i, i+1);
            total += countOdd + countEven;
        }

        return total;
    }

    private static int count(String s, int left, int right) {
        if (left > right || s == null) return 0;

        int count = 0;

        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
            ++count;
        }

        return count;
    }
}
