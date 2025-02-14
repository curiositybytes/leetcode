package recursion.basic;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(palindrome(12321, 5) ? "Palindrome" : "Not a palindrome");
    }

    private static boolean palindrome(int n, int len) {
        return n == reverse(n, len-1);
    }

    private static double reverse(int n, int count) {
        if (n/10 == 0) {
            return n;
        }

        return ((n%10) * Math.pow(10, count)) + reverse(n/10, count-1);
    }
}
