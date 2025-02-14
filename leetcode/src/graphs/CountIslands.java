package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 *
 * @link <a href="https://leetcode.com/problems/number-of-islands/">...</a>
 */
public class CountIslands {

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] {
                new char[] {'1', '1', '1', '1', '0'},
                new char[] {'1', '1', '0', '1', '0'},
                new char[] {'1', '1', '0', '0', '0'},
                new char[] {'0', '0', '0', '0', '0'}
        }));

        System.out.println(numIslands(new char[][] {
                new char[] {'0', '1', '0'},
                new char[] {'1', '0', '1'},
                new char[] {'0', '1', '0'},
                new char[] {'0', '0', '0'}
        }));
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] visited = new int[rows][cols];
        int count = 0;

        for (int i=0; i<rows; ++i) {
            for (int j=0; j<cols; ++j) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    count++;
                    performBfs(grid, visited, i, j);
                }
            }
        }

        return count;
    }

    private static void performBfs(char[][] grid, int[][] visited, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        Pair curElement = new Pair(i, j);
        q.add(curElement);
        visited[i][j] = 1;

        while (!q.isEmpty()) {
            Pair polled = q.poll();
            int iIndex = polled.first;
            int jIndex = polled.second;

            for (int k=-1; k<=1; ++k) {
                for (int l=-1; l<=1; ++l) {
                    int nRow = iIndex+k;
                    int nCol = jIndex+l;
                    if (nRow < rows && nCol < cols && nRow >=0 && nCol >= 0 && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0 && Math.abs(l) != Math.abs(k)) {
                        visited[nRow][nCol] = 1;
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }

        }
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}