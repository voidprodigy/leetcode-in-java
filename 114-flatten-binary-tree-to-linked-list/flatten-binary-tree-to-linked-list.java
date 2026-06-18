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

    TreeNode prev = null;

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        // Process right subtree first
        flatten(root.right);

        // Process left subtree
        flatten(root.left);

        // Connect current node to previous node
        root.right = prev;
        root.left = null;

        // Update previous node
        prev = root;
    }
}