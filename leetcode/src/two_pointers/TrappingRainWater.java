package two_pointers;

import java.util.Arrays;

/**
 * 42. trapping rain water
 *
 * @link <a href="https://leetcode.com/problems/trapping-rain-water/">...</a>
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    private static int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int curMax = height[0];
        int curMaxR = height[height.length-1];

        int result = 0;

        for (int i=1; i<height.length; i++) {
            maxLeft[i] = curMax;
            curMax = Math.max(curMax, height[i]);
            maxRight[height.length-i] = curMaxR;
            curMaxR = Math.max(curMaxR, height[height.length-i-1]);
        }

        for (int i=0; i<height.length; ++i) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min - height[i] >= 0) {
                result += min - height[i];
            }
        }

        return result;
    }
}
