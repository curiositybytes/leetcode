package priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Last Stone Weight
 *
 * @link <a href="https://www.naukri.com/code360/problems/last-stone-weight_630419?interviewBundleRedirection=true&leftPanelTabValue=PROBLEM">...</a>
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(weightOfLastStone(new int[] {60,37,6,100,76,47,25,69,10,8,90,5,20,87,55,15,14,72,32,22,34,42,4,38,27,85,88,65,89,35}));
        System.out.println(weightOfLastStone(new int[] {8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8}));
    }

    private static int weightOfLastStone(int arr[]) {

        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i: arr) {
            q.offer(i);
        }

        while (!q.isEmpty() && q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            q.offer(Math.abs(a-b));
        }

        return q.poll();
    }
}
