class Solution {
    private int count;

    public int countPairs(TreeNode root, int distance) {
        count = 0;
        dfs(root, distance);
        return count;
    }

    private int[] dfs(TreeNode node, int distance) {
        if (node == null) {
            return new int[distance + 1];
        }

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            int[] leafDist = new int[distance + 1];
            leafDist[1] = 1; // Leaf node is at distance 1 from itself
            return leafDist;
        }

        // Get distances from left and right subtrees
        int[] leftDist = dfs(node.left, distance);
        int[] rightDist = dfs(node.right, distance);

        // Count valid pairs
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    count += leftDist[i] * rightDist[j];
                }
            }
        }

        // Create the distance array for the current node
        int[] currDist = new int[distance + 1];
        for (int i = 2; i <= distance; i++) {
            currDist[i] = leftDist[i - 1] + rightDist[i - 1];
        }

        return currDist;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
