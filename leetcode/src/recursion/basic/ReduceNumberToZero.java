package recursion.basic;

/**
 * 1342. Number of Steps to Reduce a Number to Zero
 *
 * @link https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
 */
public class ReduceNumberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(123));
    }

    private static int numberOfSteps(int num) {
        return reducer(num, 0);
    }

    private static int reducer(int num, int count) {
        if (num == 0) {
            return count;
        }
        if (num%2 ==0) {
            return reducer(num/2, count+1);
        } else {
            return reducer(num-1, count+1);
        }
    }
}
