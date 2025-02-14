package recursion.basic;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(calculateFactorial(0));
    }

    private static int calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * calculateFactorial(n-1);
    }
}
