package dynamic_programming;

import java.util.Arrays;

public class HouseRobber2 {

    public static void main(String[] args) {
        System.out.println(rob(new int[] {2,3,2}));
    }

    private static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(
                robHelper(Arrays.copyOf(nums, nums.length), 0, 3),
                robHelper(Arrays.copyOf(nums, nums.length), 1, 2));
    }

    private static int robHelper(int[] nums, int baseIndex, int var) {
        final int lastIndex = nums.length-var;
        for (int i=lastIndex; i>=baseIndex; --i) {
            final int amt = nums[i];
            final int nextAmt = nums[i+1];
            int skipAmt = (i+var)<nums.length ? amt + nums[i+2] : 0;
            nums[i] = Math.max(amt, Math.max(nextAmt, skipAmt));
        }

        return Math.max(nums[0], nums[1]);
    }
}
