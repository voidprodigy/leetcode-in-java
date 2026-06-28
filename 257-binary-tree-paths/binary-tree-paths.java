/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        dfs(root, "", ans);

        return ans;
    }

    private void dfs(TreeNode node, String path, List<String> ans) {

        if (node == null)
            return;

        // Add current node to path
        if (path.length() == 0)
            path = String.valueOf(node.val);
        else
            path = path + "->" + node.val;

        // If it's a leaf node, store the path
        if (node.left == null && node.right == null) {
            ans.add(path);
            return;
        }

        // Traverse left and right
        dfs(node.left, path, ans);
        dfs(node.right, path, ans);
    }
}