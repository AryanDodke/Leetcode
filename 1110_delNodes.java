import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private List<TreeNode> ans;

    private TreeNode dfs(TreeNode root, Set<Integer> toDelete, boolean isRoot) {
        if (root == null) {
            return null;
        }

        boolean deleted = toDelete.contains(root.val);
        if (isRoot && !deleted) {
            ans.add(root);
        }

        root.left = dfs(root.left, toDelete, deleted);
        root.right = dfs(root.right, toDelete, deleted);

        return deleted ? null : root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        for (int val : to_delete) {
            toDelete.add(val);
        }
        dfs(root, toDelete, true);
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);

        int[] to_delete = {3, 5};
        List<TreeNode> result = solution.delNodes(root, to_delete);

        // Printing the values of the resulting forest roots
        for (TreeNode node : result) {
            System.out.println(node.val);
        }
    }
}
