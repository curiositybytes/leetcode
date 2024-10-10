package two_pointers;

import java.util.Arrays;

/**
 * 167. two-sum-ii-input-array-is-sorted
 *
 * @link <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/">...</a>
 */
public class TwoSumII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1,0}, -1)));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        for (int l=0, r=numbers.length-1; l<r;) {
            int add = numbers[l] + numbers[r];

            if (add > target) {
                r--;
            } else if (add < target) {
                l++;
            } else {
                res[0] = l+1;
                res[1] = r+1;
                break;
            }
        }

        return res;
    }
}
