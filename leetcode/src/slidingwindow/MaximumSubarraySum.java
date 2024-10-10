package slidingwindow;

/**
 * 53. maximum subarray
 *
 * @link <a href="https://leetcode.com/problems/maximum-subarray/submissions/">...</a>
 */
public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-1}));
    }

    private static int maxSubArray(int[] nums) {
        int n = nums.length;
        double sum=0;
        double max=Double.NEGATIVE_INFINITY;

        for (int i=0; i<n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }

        return (int)max;
    }
}
