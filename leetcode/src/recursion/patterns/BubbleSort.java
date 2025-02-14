package recursion.patterns;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[] {10, 5, 22, 54, 98};
        System.out.println(Arrays.toString(arr));
        sort(arr, arr.length-2, 0);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr, int r, int c) {
        if (r == 0) {
            return;
        }

        if (c < r) {
            if (arr[c] > arr[c+1]) {
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            sort(arr, r, c+1);
        } else {
            sort(arr, r-1, 0);
        }
    }
}
