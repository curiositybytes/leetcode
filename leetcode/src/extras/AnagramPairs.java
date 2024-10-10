package extras;

import java.util.HashMap;

/**
 * Anagram Pairs
 *
 * @link <a href="https://www.naukri.com/code360/problems/anagram-pairs_626517?interviewBundleRedirection=true&leftPanelTabValue=SUBMISSION">...</a>
 */
public class AnagramPairs {

    public static void main(String[] args) {
        System.out.println(isAnagram("lapdmyzwvh", "plxmrsgzjn"));
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> count = new HashMap<>();
        int matches = str1.length();

        for (char c: str1.toCharArray()) {
            count.put(c, count.getOrDefault(c,0) + 1);
        }

        for (char c: str2.toCharArray()) {
            if (!count.containsKey(c)) {
                return false;
            }

            if (count.containsKey(c) && count.get(c) != 0) {
                count.put(c, count.getOrDefault(c,0) - 1);
                matches--;
            }
        }

        return matches == 0;

    }
}
