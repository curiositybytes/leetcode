package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 * @link <a href="https://leetcode.com/problems/combination-sum-ii/">...</a>
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    private static void findCombinations(int[] nums, int target, int index, List<List<Integer>> result, List<Integer> set) {

        if (target == 0) {
            result.add(new ArrayList<>(set));
            return;
        }

        for (int i=index; i<nums.length; ++i) {
            if (i>index && nums[i] == nums[i-1]) continue;
            if (nums[i] > target) break;

            set.add(nums[i]);
            findCombinations(nums, target-nums[i], i+1, result, set);
            set.removeLast();
        }
    }
}
