package dynamic_programming;

/**
 * 746. Min Cost Climbing Stairs
 *
 * @link <a href="https://leetcode.com/problems/min-cost-climbing-stairs/description/">...</a>
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[] {10, 15, 20}));
    }

    private static int minCostClimbingStairs(int[] cost) {
        for (int i=cost.length-3; i>=0; --i) {
            int curCost = cost[i];
            int cost1 = curCost + cost[i+1];
            int cost2 = curCost + cost[i+2];
            cost[i] = Math.min(cost1, cost2);
        }

        return Math.min(cost[0], cost[1]);
    }
}
