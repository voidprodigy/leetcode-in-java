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

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }

        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        /*
         * Empty tree case.
         */
        if (start > end) {
            result.add(null);
            return result;
        }

        /*
         * Try every value as root.
         */
        for (int rootVal = start;
             rootVal <= end;
             rootVal++) {

            /*
             * Generate all possible
             * left subtrees.
             */
            List<TreeNode> leftTrees =
                    build(start, rootVal - 1);

            /*
             * Generate all possible
             * right subtrees.
             */
            List<TreeNode> rightTrees =
                    build(rootVal + 1, end);

            /*
             * Combine every left tree
             * with every right tree.
             */
            for (TreeNode left : leftTrees) {

                for (TreeNode right : rightTrees) {

                    TreeNode root =
                            new TreeNode(rootVal);

                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }
        }

        return result;
    }
}