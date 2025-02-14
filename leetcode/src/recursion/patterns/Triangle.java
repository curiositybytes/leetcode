package recursion.patterns;

public class Triangle {

    public static void main(String[] args) {
        reverseRightTriangle(4, 0);
        rightTriangle(4, 0);
    }

    private static void rightTriangle(int r, int c) {
        if (r==0) {
            return;
        }

        if (c < r) {
            rightTriangle(r, c+1);
            System.out.print("*");
        } else {
            rightTriangle(r-1, 0);
            System.out.println();
        }
    }

    private static void reverseRightTriangle(int r, int c) {
        if (r==0) {
            return;
        }

        if (c < r) {
            System.out.print("*");
            reverseRightTriangle(r, c+1);
        } else {
            System.out.println();
            reverseRightTriangle(r-1, 0);
        }
    }
}
