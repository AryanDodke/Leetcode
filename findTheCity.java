import java.util.*;

class Solution {
    class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        int city = -1;
        int minReachableCities = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reachableCities = countReachableCities(adjList, i, n, distanceThreshold);
            if (reachableCities <= minReachableCities) {
                if (reachableCities == minReachableCities) {
                    city = Math.max(city, i); // In case of a tie, choose the city with the larger index
                } else {
                    city = i;
                }
                minReachableCities = reachableCities;
            }
        }

        return city;
    }

    private int countReachableCities(List<List<Pair>> adjList, int startNode, int n, int distanceThreshold) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;
        pq.offer(new Pair(startNode, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentNode = current.node;
            int currentDist = current.distance;

            for (Pair neighbor : adjList.get(currentNode)) {
                int newDist = currentDist + neighbor.distance;
                if (newDist < dist[neighbor.node] && newDist <= distanceThreshold) {
                    dist[neighbor.node] = newDist;
                    pq.offer(new Pair(neighbor.node, newDist));
                }
            }
        }

        int reachableCities = 0;
        for (int d : dist) {
            if (d <= distanceThreshold) {
                reachableCities++;
            }
        }
        return reachableCities - 1; // Exclude the startNode itself
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int n1 = 4;
        int[][] edges1 = {{0, 1, 3}, {1, 2, 1}, {2, 3, 4}, {0, 3, 10}};
        int distanceThreshold1 = 4;
        System.out.println(solution.findTheCity(n1, edges1, distanceThreshold1)); // Output: 3
        
        int n2 = 5;
        int[][] edges2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int distanceThreshold2 = 2;
        System.out.println(solution.findTheCity(n2, edges2, distanceThreshold2)); // Output: 0
    }
}
