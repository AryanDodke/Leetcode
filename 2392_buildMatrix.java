import java.util.*;

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        
        // Perform topological sort for row conditions
        int[] rowOrder = topologicalSort(k, rowConditions);
        if (rowOrder == null) {
            return new int[0][0];
        }
        
        // Perform topological sort for column conditions
        int[] colOrder = topologicalSort(k, colConditions);
        if (colOrder == null) {
            return new int[0][0];
        }
        
        // Map values to their positions in row and column orders
        int[] rowIndex = new int[k + 1];
        int[] colIndex = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rowIndex[rowOrder[i]] = i;
            colIndex[colOrder[i]] = i;
        }
        
        // Place the numbers in the matrix
        for (int num = 1; num <= k; num++) {
            matrix[rowIndex[num]][colIndex[num]] = num;
        }
        
        return matrix;
    }

    private int[] topologicalSort(int k, int[][] conditions) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[k + 1];
        int[] indegree = new int[k + 1];
        
        for (int i = 1; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph[u].add(v);
            indegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] order = new int[k];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;
            
            for (int neighbor : graph[node]) {
                if (--indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return index == k ? order : null;
    }

}
