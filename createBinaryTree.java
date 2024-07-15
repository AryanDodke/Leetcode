import java.util.*;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        // First pass: Create all nodes and populate the map
        for (int[] d : descriptions) {
            map.putIfAbsent(d[0], new TreeNode(d[0]));
            map.putIfAbsent(d[1], new TreeNode(d[1]));
        }

        // Second pass: Assign children to their parents
        for (int[] d : descriptions) {
            TreeNode parent = map.get(d[0]);
            TreeNode child = map.get(d[1]);
            children.add(d[1]);
            if (d[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // The root will be the only node that is not a child
        TreeNode root = null;
        for (int key : map.keySet()) {
            if (!children.contains(key)) {
                root = map.get(key);
                break;
            }
        }

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
