package slidingwindow;


import java.util.HashMap;

/**
 * 424. longest-repeating-character-replacement
 *
 * @link <a href="https://leetcode.com/problems/longest-repeating-character-replacement/description/">...</a>
 *
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        int sLen = s.length();
        if (sLen==0 || sLen==1) {
            return sLen;
        }

        if (sLen <= k) {
            return sLen;
        }

        HashMap<Character, Integer> freq = new HashMap<>();
        int l=0, len = 0;
        int maxFreq = 0;

        for (int r=0; r<sLen; ++r) {
            char ch = s.charAt(r);
            freq.putIfAbsent(ch, 0);
            freq.put(ch, freq.get(ch) + 1);
            maxFreq = Math.max(maxFreq, freq.get(ch));
            int windowSize = r-l+1;
            while ((windowSize - maxFreq) > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l += 1;
                windowSize = r-l+1;
            }

            len = Math.max(len, windowSize);
        }

        return len;
    }
}
