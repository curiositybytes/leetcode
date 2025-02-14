package recursion.maze;

import java.util.Arrays;

public class NQueens {

    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(findCombinationCount(0, board));
    }

    private static int findCombinationCount(int r, boolean[][] board) {
        if (r == board.length) {
            display(board);
            return 1;
        }

        int count = 0;

        for (int i=0; i<board.length; ++i) {
            if (isSafe(r, i, board)) {
                board[r][i] = true;
                count += findCombinationCount(r+1, board);
                board[r][i] = false;
            }
        }

        return count;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (int j = 0; j < board.length; ++j) {
                System.out.print(row[j] ? 'Q' : 'X');
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSafe(int r, int c, boolean[][] board) {
        for (int i=0; i<r; ++i) {
            if (board[i][c]) {
                return false;
            }
        }

        int maxLeft = Math.min(r, c);
        for (int i=1; i<=maxLeft; ++i) {
            if (board[r-i][c-i]) {
                return false;
            }
        }

        int maxRight = Math.min(r, board.length - c - 1);
        for (int i=1; i<=maxRight; ++i) {
            if (board[r-i][c+i]) {
                return false;
            }
        }
        return true;
    }
}
