package recursion.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {4,3,2,10,19,20,18};
        sort(nums, 0, nums.length-1);
        for (int i: nums) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] nums, int low, int high) {
        if (low >= high) { return; }

        int mid = (low + high) / 2;
        sort(nums, low, mid);
        sort(nums, mid+1, high);
        merge(nums, low, mid, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] result = new int[high - low + 1];

        int leftIndex = low;
        int rightIndex = mid+1;
        int resultIndex = 0;
        while (leftIndex <= mid && rightIndex <= high) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                result[resultIndex++] = nums[leftIndex++];
            } else {
                result[resultIndex++] = nums[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            result[resultIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= high) {
            result[resultIndex++] = nums[rightIndex++];
        }

        for(int i=0; i<result.length; ++i) {
            nums[low+i] = result[i];
        }
    }
}
