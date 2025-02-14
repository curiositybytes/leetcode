package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        Arrays.stream(floodFill(new int[][] {
                new int[] {1,1,1},
                new int[] {1,1,0},
                new int[] {1,0,1}
        }, 1, 1, 2)).map(Arrays::toString).forEach(System.out::println);

        System.out.println();

        Arrays.stream(floodFill(new int[][] {
                new int[] {0,0,0},
                new int[] {0,0,0}
        }, 1, 1, 2)).map(Arrays::toString).forEach(System.out::println);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        performRecursion(image, sr, sc, color, originalColor);

        return image;
    }

    private static void performRecursion(int[][] image, int sr, int sc, int color, int originalColor) {
        int rows = image.length;
        int cols = image[0].length;

        if (sr>=0 && sc>=0 && sr<rows && sc<cols && image[sr][sc] == originalColor) {
            image[sr][sc] = color;
            performRecursion(image, sr, sc+1, color, originalColor);
            performRecursion(image, sr, sc-1, color, originalColor);
            performRecursion(image, sr+1, sc, color, originalColor);
            performRecursion(image, sr-1, sc, color, originalColor);
        }
    }
}