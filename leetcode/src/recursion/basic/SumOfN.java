package recursion.basic;

public class SumOfN {

    public static void main(String[] args) {
        System.out.println(sum(10));
    }

    private static int sum(int n) {
        if (n == 1 || n==0 || n==-1) {
            return n;
        }

        return n + sum(n-1);
    }
}
