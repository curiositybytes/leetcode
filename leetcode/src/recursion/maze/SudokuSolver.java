package recursion.maze;

public class SudokuSolver {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }
    }

    private static boolean solve(int[][] board) {
        int n = board.length;
        int r = -1;
        int c = -1;
        boolean emptyLeft = true;

        for (int i=0; i<n; ++i) {
            for (int j=0; j<n; ++j) {
                if (board[i][j] == 0) {
                    r = i;
                    c = j;
                    emptyLeft = false;
                    break;
                }
            }

            if (!emptyLeft) {
                break;
            }
        }

        if (emptyLeft) {
            return true;
        }

        for (int j=1; j<=9; ++j) {
            if (isSafe(r, c, board, j)) {
                board[r][c] = j;
                if (solve(board)) {
                    return true;
                } else {
                    board[r][c] = 0;
                }
            }
        }
        return false;
    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int j=0; j<9; ++j) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isSafe(int r, int c, int[][] board, int n) {
        for (int i=0; i<board.length; ++i) {
            if (board[r][i] == n) {
                return false;
            }
        }

        for (int[] nums : board) {
            if (nums[c] == n) {
                return false;
            }
        }

        int boxLength = (int)(Math.sqrt(board.length));
        int start = r-r%boxLength;
        int colStart = c-c%boxLength;
        for (int i=start; i<start+boxLength; ++i) {
            for (int j=colStart; j<colStart+boxLength; ++j) {
                if (board[i][j] == n) {
                    return false;
                }
            }
        }

        return true;
    }
}
