package graphs;

import java.util.ArrayList;

/**
 * 547. Number of Provinces
 *
 * @link <a href="https://leetcode.com/problems/number-of-provinces/description/">...</a>
 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][] {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        }));
    }

    private static int findCircleNum(int[][] isConnected) {
        int rows = isConnected.length;
        int cols = isConnected[0].length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0; i<=cols; ++i) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i=0; i<rows; ++i) {
            for (int j=0; j<cols; ++j) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }

        int count = 0;
        int[] visited = new int[rows+1];

        for (int i=0; i<rows; ++i) {
            int curNode = i+1;
            if (visited[curNode] == 0) {
                count++;
                performDfs(adj, curNode, visited);
            }
        }

        return count;
    }

    private static void performDfs(ArrayList<ArrayList<Integer>> adj, int node, int[] visited) {
        visited[node] = 1;
        for (int i : adj.get(node)) {
            if (visited[i] == 0) {
                performDfs(adj, i, visited);
            }
        }
    }
}
