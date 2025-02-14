package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS of graph
 *
 * @link <a href="https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1">...</a>
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        bfsOfGraph(5, new ArrayList<>() {
            {
                add(new ArrayList<>(List.of(2,3,1)));
                add(new ArrayList<>(List.of(0)));
                add(new ArrayList<>(List.of(0,4)));
                add(new ArrayList<>(List.of(0)));
                add(new ArrayList<>(List.of(2)));
            }
        }).forEach(System.out::print);
    }

    private static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] visited = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 1;

        while (!queue.isEmpty()) {
            int polled = queue.poll();
            result.add(polled);
            for (int i : adj.get(polled)) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }

        return result;
    }
}
