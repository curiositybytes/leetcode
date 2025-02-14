package recursion.maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Youtube playlist of kunal kuswaha
 *
 * The ways to reach from source position to the end position in a 2-D matrix of dimension n*n
 */
public class ReachTargetPosition {

    public static void main(String[] args) {
        System.out.println(countWaysToReachTarget(3, 0, 0));

        List<String> resultPaths = new ArrayList<>();
        printPathsToReachTarget(3, 0, 0, "", resultPaths);
        System.out.println(resultPaths);
        System.out.println();

        resultPaths = new ArrayList<>();
        printPathsToReachTargetWithDiagonal(3, 0, 0, "", resultPaths);
        System.out.println(resultPaths);
        System.out.println();

        resultPaths = new ArrayList<>();
        boolean[][] visited = new boolean[][] {{false, false, false}, {false, false, false}, {false, false, false}};
        System.out.println(printPathsToReachTargetWithAllFourDirections(3, 0, 0, "", resultPaths, visited));
        System.out.println(resultPaths);

    }

    private static int countWaysToReachTarget(int dimension, int rowStart, int colStart) {
        if (rowStart == dimension-1 || colStart == dimension-1) {
            return 1;
        }

        return countWaysToReachTarget(dimension, rowStart+1, colStart) +
                countWaysToReachTarget(dimension, rowStart, colStart+1);
    }

    private static void printPathsToReachTarget(int dimension, int rowStart, int colStart, String path, List<String> resultPaths) {
        if (rowStart == dimension-1 && colStart == dimension-1) {
            resultPaths.add(path);
            return;
        }

        if (rowStart < dimension-1) {
            printPathsToReachTarget(dimension, rowStart+1, colStart, path + 'D', resultPaths);
        }

        if (colStart < dimension-1) {
            printPathsToReachTarget(dimension, rowStart, colStart+1, path + 'R', resultPaths);
        }
    }

    private static void printPathsToReachTargetWithDiagonal(int dimension, int rowStart, int colStart, String path, List<String> resultPaths) {
        if (rowStart == dimension-1 && colStart == dimension-1) {
            resultPaths.add(path);
            return;
        }

        if (rowStart < dimension-1 && colStart < dimension-1) {
            printPathsToReachTargetWithDiagonal(dimension, rowStart+1, colStart+1, path + 'D', resultPaths);
        }

        if (rowStart < dimension-1) {
            printPathsToReachTargetWithDiagonal(dimension, rowStart+1, colStart, path + 'V', resultPaths);
        }

        if (colStart < dimension-1) {
            printPathsToReachTargetWithDiagonal(dimension, rowStart, colStart+1, path + 'H', resultPaths);
        }
    }

    private static int printPathsToReachTargetWithAllFourDirections(int dimension, int rowStart, int colStart,
                                                                     String path, List<String> resultPaths, boolean[][] visited) {

        if (rowStart == dimension-1 && colStart == dimension-1) {
            resultPaths.add(path);
            return 1;
        }

        if (visited[rowStart][colStart]) {
            return 0;
        }

        int pathCount = 0;
        visited[rowStart][colStart] = true;

        if (rowStart > 0) {
            pathCount += printPathsToReachTargetWithAllFourDirections(dimension, rowStart-1, colStart, path + 'U', resultPaths, visited);
        }

        if (rowStart < dimension-1) {
            pathCount += printPathsToReachTargetWithAllFourDirections(dimension, rowStart+1, colStart, path + 'D', resultPaths, visited);
        }

        if (colStart > 0) {
            pathCount += printPathsToReachTargetWithAllFourDirections(dimension, rowStart, colStart-1, path + 'L', resultPaths, visited);
        }

        if (colStart < dimension-1) {
            pathCount += printPathsToReachTargetWithAllFourDirections(dimension, rowStart, colStart+1, path + 'R', resultPaths, visited);
        }

        visited[rowStart][colStart] = false;

        return pathCount;
    }
}
