package dynamic_programming;

/**
 * 198. House Robber
 *
 * @link <a href="https://leetcode.com/problems/house-robber/description/">...</a>
 */
public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,2,3,1}));
    }

    private static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        for (int i=nums.length-2; i>=0; --i) {
            final int amount = nums[i];
            final int nextAmount = nums[i+1];
            final int skipAmount = (i+2)<nums.length ? amount + nums[i+2] : 0;
            nums[i] = Math.max(amount, Math.max(nextAmount, skipAmount));
        }

        return Math.max(nums[0], nums[1]);
    }
}
