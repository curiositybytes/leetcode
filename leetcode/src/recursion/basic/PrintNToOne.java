package recursion.basic;

public class PrintNToOne {
    public static void main(String[] args) {
        print(5);
        printWithReturn(5);
    }

    private static void print(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        print(n-1);
    }

    private static int printWithReturn(int n) {
        if (n != 0) {
            System.out.println(n);
            printWithReturn(n-1);
        }

        return -1;
    }
}
