package recursion.arrays;

public class BinarySearch {

    public static void main(String[] args) {
        final int[] arr = new int[] {10, 20, 40, 45, 55};
        System.out.println(search(arr, 0, arr.length-1, 55));
    }

    private static int search(int[] arr, int start, int end, int target) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return search(arr, start, mid-1, target);
        } else {
            return search(arr, mid+1, end, target);
        }
    }
}
