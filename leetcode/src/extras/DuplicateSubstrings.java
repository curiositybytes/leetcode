package extras;

/**
 * Remove duplicate substrings
 *
 * @link <a href="https://www.naukri.com/code360/problems/remove-duplicate-substrings_3646101?interviewBundleRedirection=true">...</a>
 */
public class DuplicateSubstrings {

    public static void main(String[] args) {
        System.out.println(removeDuplicateSubstrings(10, 2, "abcbacaacd"));
        System.out.println(removeDuplicateSubstrings(8, 3, "ababbbbc"));
        System.out.println(removeDuplicateSubstrings(8, 3, "aaaallli"));
        System.out.println(removeDuplicateSubstrings(8, 2, "jjjjwwnh"));
    }

    private static String removeDuplicateSubstrings(int n, int k, String s) {
        int counter = 0;
        int j = 0;
        String temp = "";
        for (int i=0; i<n-k;) {
            counter = 1;
            j = i;
            while (j<=n-2 && s.charAt(j) == s.charAt(j+1) && counter != k) {
                counter++;
                j++;
            }

            if (counter == k) {
                s = s.replace(s.substring(i, i+k), "");
                if (i!=0) {
                    i--;
                }
            } else {
                i++;
            }

            n = s.length();
        }
        return s;
    }
}
