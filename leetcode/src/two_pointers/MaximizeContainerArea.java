package two_pointers;

/**
 * 11. container with most water
 *
 * @link <a href="https://leetcode.com/problems/container-with-most-water/description/">...</a>
 */
public class MaximizeContainerArea {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[] {1,1}));
    }

    private static int maxArea(int[] height) {
        int maxArea = 0;
        for (int l=0, r=height.length-1; l<r;) {
            int lh = height[l];
            int rh = height[r];
            int width = r-l;
            int curArea = 0;
            if (lh < rh) {
                curArea = lh * width;
                l++;
            } else {
                curArea = rh * width;
                r--;
            }

            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }
}
