package dynamic_programming;

/**
 * 70. Climbing Stairs
 *
 * @link <a href="https://leetcode.com/problems/climbing-stairs/description/">...</a>
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    private static int climbStairs(int n) {
        if (n==1) return 1;

        int baseCase1 = 1;
        int baseCase2 = 2;

        for (int i=3; i<=n; ++i) {
            int temp = baseCase2;
            baseCase2 += baseCase1;
            baseCase1 = temp;
        }

        return baseCase2;
    }
}
