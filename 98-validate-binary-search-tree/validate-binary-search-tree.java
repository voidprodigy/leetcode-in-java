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

    public boolean isValidBST(TreeNode root) {

        return validate(root, Long.MIN_VALUE,
                              Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node,
                             long min,
                             long max) {

        // Empty tree is valid
        if (node == null) {
            return true;
        }

        /*
         * Current node must lie
         * strictly between min and max.
         */
        if (node.val <= min ||
            node.val >= max) {
            return false;
        }

        /*
         * Left subtree:
         * values < node.val
         */
        boolean left =
                validate(node.left,
                         min,
                         node.val);

        /*
         * Right subtree:
         * values > node.val
         */
        boolean right =
                validate(node.right,
                         node.val,
                         max);

        return left && right;
    }
}