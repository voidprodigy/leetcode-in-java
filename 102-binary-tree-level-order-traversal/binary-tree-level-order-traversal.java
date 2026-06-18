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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // If tree is empty
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        // Start BFS from root
        queue.offer(root);

        while (!queue.isEmpty()) {

            // Number of nodes at current level
            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            // Process all nodes of current level
            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                level.add(current.val);

                // Add left child if present
                if (current.left != null) {
                    queue.offer(current.left);
                }

                // Add right child if present
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Store current level
            result.add(level);
        }

        return result;
    }
}