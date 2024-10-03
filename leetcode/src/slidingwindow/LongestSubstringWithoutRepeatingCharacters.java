package slidingwindow;

/**
 * 3. longest-substring-without-repeating-characters
 *
 * @link <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/description/">...</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int l=0, len = 0;
        StringBuilder res = new StringBuilder();

        for (int r=0; r<s.length(); ++r) {
            char ch = s.charAt(r);
            while (res.toString().indexOf(ch) != -1) {
                res = new StringBuilder(res.substring(1));
            }
            res.append(ch);
            len = Math.max(len, res.length());
        }
        return len;
    }
}
