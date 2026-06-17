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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        /*
         * If both nodes are null,
         * trees match at this position.
         */
        if (p == null && q == null) {
            return true;
        }

        /*
         * If one is null and the other isn't,
         * structures are different.
         */
        if (p == null || q == null) {
            return false;
        }

        /*
         * Node values must be equal.
         */
        if (p.val != q.val) {
            return false;
        }

        /*
         * Both left subtrees and right subtrees
         * must be identical.
         */
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}