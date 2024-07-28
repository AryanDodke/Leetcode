import java.util.*;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // Create adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Priority queue to process nodes in the order of their current time
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0}); // Start at vertex 1 with time 0

        // Arrays to track the minimum and second minimum time to reach each vertex
        int[] firstMin = new int[n + 1];
        int[] secondMin = new int[n + 1];
        Arrays.fill(firstMin, Integer.MAX_VALUE);
        Arrays.fill(secondMin, Integer.MAX_VALUE);
        firstMin[1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int currTime = curr[1];

            for (int neighbor : graph.get(node)) {
                // Calculate the next time based on the current traffic signal state
                int nextTime = currTime + time;
                if ((currTime / change) % 2 == 1) { // If current state is red, wait for it to turn green
                    nextTime += change - (currTime % change);
                }

                // Check if this is a valid second minimum path
                if (nextTime < firstMin[neighbor]) {
                    secondMin[neighbor] = firstMin[neighbor];
                    firstMin[neighbor] = nextTime;
                    pq.offer(new int[]{neighbor, nextTime});
                } else if (nextTime > firstMin[neighbor] && nextTime < secondMin[neighbor]) {
                    secondMin[neighbor] = nextTime;
                    pq.offer(new int[]{neighbor, nextTime});
                }
            }
        }

        // The second minimum time to reach vertex n
        return secondMin[n];
    }
}
