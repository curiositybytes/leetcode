package recursion.basic;

public class PrintOneToN {

    public static void main(String[] args) {
        print(5, 1);
    }

    private static void print(int n, int start) {
        if (start == n+1) {
            return;
        }

        System.out.println(start);
        print(n, start+1);
    }
}
