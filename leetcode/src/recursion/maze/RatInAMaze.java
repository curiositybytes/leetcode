package recursion.maze;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Rat in a Maze Problem - I
 *
 * @link <a href="https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1">...</a>
 */
public class RatInAMaze {
    public static void main(String[] args) {
        Integer[] mazeRow1 = {1,1,0,0,1};
        Integer[] mazeRow2 = {1,1,1,1,0};
        Integer[] mazeRow3 = {1,1,1,0,1};
        Integer[] mazeRow4 = {0,0,1,0,0};
        Integer[] mazeRow5 = {1,1,1,1,1};
        ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(mazeRow1));
        ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(mazeRow2));
        ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(mazeRow3));
        ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(mazeRow4));
        ArrayList<Integer> row5 = new ArrayList<>(Arrays.asList(mazeRow5));
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(row1);
        input.add(row2);
        input.add(row3);
        input.add(row4);
        input.add(row5);
        System.out.println(findPath(input));
    }

    private static ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[mat.size()][mat.size()];
        move(mat, result, "", 0, 0, visited);
        return result;
    }

    private static void move(ArrayList<ArrayList<Integer>> mat, ArrayList<String> result,
                             String path, int r, int c, boolean[][] visited) {

        int n = mat.size();

        if (r == n-1 && c== n-1) {
            result.add(path);
            return;
        }

        if (visited[r][c] || mat.get(r).get(c) == 0) {
            return;
        }

        visited[r][c] = true;

        if (r < n - 1) {
            move(mat, result, path + "D", r+1, c, visited);
        }

        if (c > 0) {
            move(mat, result, path + "L", r, c-1, visited);
        }

        if (c < n - 1) {
            move(mat, result, path + "R", r, c+1, visited);
        }

        if (r > 0) {
            move(mat, result, path + "U", r-1, c, visited);
        }

        visited[r][c] = false;
    }
}
