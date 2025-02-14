package recursion.maze;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 *
 * @link <a href="https://leetcode.com/problems/n-queens/submissions/1491336586/">...</a>
 */
public class NQueensLeetcode {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> solution = new ArrayList<>();
        for (int i=0; i<n; ++i) {
            solution.add(".".repeat(n));
        }
        return solve(n, 0, result, solution);
    }

    private static List<List<String>> solve(int n, int r, List<List<String>> result, List<String> solution) {
        if (r == n) {
            result.add(new ArrayList<>(solution));
            return result;
        }

        String curRow = solution.get(r);

        for (int c=0; c<n; ++c) {
            if (isSafe(solution, r, c, n)) {
                curRow = curRow.substring(0, c) + "Q" + curRow.substring(c+1);
                solution.set(r, curRow);
                solve(n, r+1, result, solution);
                curRow = ".".repeat(n);
                solution.set(r, curRow);
            }
        }

        return result;
    }

    private static boolean isSafe(List<String> solution, int r, int c, int n) {
        for (int i=0; i<r; ++i) {
            if (solution.get(i).charAt(c) == 'Q') {
                return false;
            }
        }

        int maxLeft = Math.min(r, c);
        for (int i=1; i<=maxLeft; ++i) {
            if (solution.get(r-i).charAt(c-i) == 'Q') {
                return false;
            }
        }

        int maxRight = Math.min(r, n-c-1);
        for (int i=1; i<=maxRight; ++i) {
            if (solution.get(r-i).charAt(c+i) == 'Q') {
                return false;
            }
        }

        return true;
    }
}
