package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS of Graph
 *
 * @link <a href="https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1">...</a>
 */
public class DepthFirstSearch {

    public static void main(String[] args) {
        dfsOfGraph(new ArrayList<>() {
            {
                add(new ArrayList<>(List.of(2,3,1)));
                add(new ArrayList<>(List.of(0)));
                add(new ArrayList<>(List.of(0,4)));
                add(new ArrayList<>(List.of(0)));
                add(new ArrayList<>(List.of(2)));
            }
        }).forEach(System.out::print);
    }

    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        int size = adj.size();
        performDfs(adj, 0, result, new int[size]);

        return result;
    }

    private static void performDfs(ArrayList<ArrayList<Integer>> adj, int node,
                                   ArrayList<Integer> result, int[] visited) {

        visited[node] = 1;
        result.add(node);
        int size = adj.get(node).size();
        for (int i=0; i<size; ++i) {
            int neighbor = adj.get(node).get(i);
            if (visited[neighbor] == 0) {
                performDfs(adj, neighbor, result, visited);
            }
        }
    }
}
