package recursion.basic;

public class ProductOfDigits {

    public static void main(String[] args) {
        System.out.print(Math.abs(productOfDigits(134)));
    }

    private static int productOfDigits(int n) {
        if (n / 10 == 0) {
            return n;
        }

        return (n%10) * productOfDigits(n/10);
    }
}
