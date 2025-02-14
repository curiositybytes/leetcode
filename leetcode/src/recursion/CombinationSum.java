package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 *
 * @link <a href="https://leetcode.com/problems/combination-sum/">...</a>
 */
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {2,3,6,7}, 7));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return findSubsets(candidates, target, new ArrayList<Integer>(), 0);
    }

    private static List<List<Integer>> findSubsets(int[] nums, int target, List<Integer> result, int index) {

        if (target == 0) {
            List<List<Integer>> subset = new ArrayList<>();
            subset.add(new ArrayList<>(result));
            return subset;
        } else if (target < 0 || index >= nums.length) {
            return new ArrayList<>();
        }
        List<List<Integer>> combinedList = new ArrayList<>();

        result.add(nums[index]);
        List<List<Integer>> left = findSubsets(nums, target-nums[index], result, index);
        result.removeLast();
        List<List<Integer>> right = findSubsets(nums, target, result, index+1);

        combinedList.addAll(left);
        combinedList.addAll(right);

        return combinedList;
    }
}
