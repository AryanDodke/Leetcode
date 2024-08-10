class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n; // Each cell is divided into 4 triangles
        UnionFind uf = new UnionFind(size);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char ch = grid[i].charAt(j);

                // Connect triangles within the current cell
                if (ch == '/') {
                    uf.union(index + 0, index + 3);
                    uf.union(index + 1, index + 2);
                } else if (ch == '\\') {
                    uf.union(index + 0, index + 1);
                    uf.union(index + 2, index + 3);
                } else {
                    uf.union(index + 0, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                }

                // Connect triangles to neighboring cells
                if (i > 0) { // Connect to the cell above
                    uf.union(index + 0, index - 4 * n + 2);
                }
                if (j > 0) { // Connect to the cell on the left
                    uf.union(index + 3, index - 4 + 1);
                }
            }
        }

        return uf.getCount();
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]); // Path compression
            }
            return parent[p];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    rank[rootP]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
