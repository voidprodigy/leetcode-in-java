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

    private int postIndex;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Store value -> index from inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {

        // No nodes in this subtree
        if (left > right) {
            return null;
        }

        // Last element in postorder is root
        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = inorderMap.get(rootValue);

        // IMPORTANT:
        // Build RIGHT subtree first
        root.right = build(postorder, inorderIndex + 1, right);

        // Then LEFT subtree
        root.left = build(postorder, left, inorderIndex - 1);

        return root;
    }
}