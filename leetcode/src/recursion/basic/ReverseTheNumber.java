package recursion.basic;

public class ReverseTheNumber {

    public static void main(String[] args) {
        int n = 1234;
        int lengthNum = 4;
        System.out.println((int)reverse(n, lengthNum-1));
    }

    private static double reverse(int n, int count) {
        if (n/10 == 0) {
            return n;
        }

        return ((n%10) * Math.pow(10, count)) + reverse(n/10, count-1);
    }
}
