package two_pointers;

/**
 * valid-palindrome
 *
 * @link <a href="https://leetcode.com/problems/valid-palindrome/description/">...</a>
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("0P"));
    }

    private static boolean isPalindrome(String s) {
        s = s.toLowerCase();

        for (int l=0, r=s.length()-1; l<r; l++, r--) {
            char lch = s.charAt(l);
            char rch = s.charAt(r);
            while (!(lch >= 97 && lch <=122) && !(lch>=48 && lch<=57) && l<r) {
                l++;
                lch = s.charAt(l);
            }

            while (!(rch >= 97 && rch <=122) && !(rch>=48 && rch<=57) && r>l) {
                r--;
                rch = s.charAt(r);
            }

            if (rch != lch) {
                return false;
            }
        }

        return true;
    }
}
