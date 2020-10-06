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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        /*
            traverse tree level by level
        */
        
        if (root == null) return root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        boolean hasFound = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            hasFound = false;
            for (int i = 0; i < size; ++i) {
                TreeNode current = queue.poll();
                if (hasFound) return current;
                if (current == u) hasFound = true;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        
        return null;
    }
}