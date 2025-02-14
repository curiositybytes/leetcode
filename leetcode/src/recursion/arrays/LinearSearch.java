package recursion.arrays;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public static void main(String[] args) {
        System.out.println(search(new int[] {1, 2, 10, 12}, 10, 0) + 1);
        System.out.println(searchAllOccurrences(new int[] {1, 2, 10, 12, 10}, 10, 0, new ArrayList<>()));
    }

    private static int search(int[] arr, int target, int index) {
        if (index == arr.length) {
            return Integer.MIN_VALUE-1;
        }

        if (arr[index] == target) {
            return index;
        }

        return search(arr, target, index+1);
    }

    private static List<Integer> searchAllOccurrences(int[] arr, int target, int index, ArrayList<Integer> result) {
        if (index == arr.length) {
            return result;
        }

        if (arr[index] == target) {
            result.add(index);
        }

        searchAllOccurrences(arr, target, index+1, result);

        return result;
    }
}
