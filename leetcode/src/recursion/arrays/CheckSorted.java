package recursion.arrays;

public class CheckSorted {

    public static void main(String[] args) {
        System.out.println(check(new int[] {1, 2, 3, 4, 5}, 1) ? "Sorted" : "Not Sorted");
    }

    private static boolean check(int[] arr, int pos) {
        if (pos == arr.length) {
            return true;
        }

        return arr[pos] > arr[pos-1] && check(arr, pos + 1);
    }
}
