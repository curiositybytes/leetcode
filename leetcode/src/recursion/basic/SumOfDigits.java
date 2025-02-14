package recursion.basic;

public class SumOfDigits {

    public static void main(String[] args) {
        System.out.print(Math.abs(sumOfDigits(-102)));
    }

    private static int sumOfDigits(int n) {
        if (n / 10 == 0) {
            return n;
        }

        return (n%10) + sumOfDigits(n/10);
    }
}
