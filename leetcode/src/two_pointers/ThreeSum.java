package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 15. 3sum
 *
 * @link <a href="https://leetcode.com/problems/3sum/">...</a>
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[] {0,1,1}));
        System.out.println(threeSum(new int[] {0,0,0}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<nums.length-2; i++) {
            if (i>0 && (nums[i] == nums[i-1])) {
                continue;
            }

            int l=i+1, r=nums.length-1;
            int target = 0;
            while (l<r) {
                int add = nums[i] + nums[l] + nums[r];
                if (add > target) {
                    r--;
                } else if (add < target) {
                    l++;
                } else {
                    List<Integer> curRes = new ArrayList<>();
                    curRes.add(nums[i]);
                    curRes.add(nums[l]);
                    curRes.add(nums[r]);
                    res.add(curRes);
                    l++;
                    while (nums[l] == nums[l-1] && l<r) {
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
