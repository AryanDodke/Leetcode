import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create the graph representation
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair(v, prob));
            graph.get(v).add(new Pair(u, prob));
        }

        // Use a max heap to keep track of the maximum probability path
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start, 1.0));

        // Track the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            double curProb = current.prob;

            if (node == end) {
                return curProb;
            }

            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                double edgeProb = neighbor.prob;

                // Calculate new probability to reach the next node
                double newProb = curProb * edgeProb;

                // If this path is better, update and push to the queue
                if (newProb > maxProb[nextNode]) {
                    maxProb[nextNode] = newProb;
                    pq.add(new Pair(nextNode, newProb));
                }
            }
        }

        return 0.0;
    }
    
    class Pair {
        int node;
        double prob;
        
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
