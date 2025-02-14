package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * @link <a href="https://leetcode.com/problems/subsets/description/">...</a>
 */
public class NumberSubsets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,2}));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        return performRecusrion(nums, 0, new ArrayList<>());
    }

    private static List<List<Integer>> performRecusrion(int[] nums, int index, List<Integer> numList) {

        if (index == nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(numList));
            return res;
        }

        List<List<Integer>> result = new ArrayList<>();

        List<List<Integer>> left = performRecusrion(nums, index+1, numList);
        numList.add(nums[index]);
        List<List<Integer>> right = performRecusrion(nums, index+1, numList);
        numList.removeLast();

        result.addAll(left);
        result.addAll(right);

        return result;
    }
}
