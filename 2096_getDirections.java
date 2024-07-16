class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        val = 0;
        left = null;
        right = null;
    }

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    String lcaToStart = "";
    String lcaToEnd = "";

    void dfs(TreeNode node, StringBuilder pathString, int p, int q) {
        if (node == null)
            return;
        if (node.val == p)
            lcaToStart = pathString.toString();
        if (node.val == q)
            lcaToEnd = pathString.toString();

        pathString.append('L');
        dfs(node.left, pathString, p, q);
        pathString.deleteCharAt(pathString.length() - 1);

        pathString.append('R');
        dfs(node.right, pathString, p, q);
        pathString.deleteCharAt(pathString.length() - 1);
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathString = new StringBuilder();
        dfs(root, pathString, startValue, destValue);

        int commonLen = 0, i = 0, j = 0;
        while (i < lcaToStart.length() && j < lcaToEnd.length()) {
            if (lcaToStart.charAt(i) == lcaToEnd.charAt(j)) {
                commonLen++;
                i++;
                j++;
            } else {
                break;
            }
        }

        lcaToStart = lcaToStart.substring(commonLen);
        lcaToEnd = lcaToEnd.substring(commonLen);

        StringBuilder result = new StringBuilder();
        for (int k = 0; k < lcaToStart.length(); k++) {
            result.append('U');
        }
        result.append(lcaToEnd);
        return result.toString();
    }
}
