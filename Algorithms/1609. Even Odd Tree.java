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
    public boolean isEvenOddTree(TreeNode root) {
        /*
            level traverse
        */
        
        if (root == null) return false;
        
        int level = 0;
        int value = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level % 2 == 0) value = Integer.MIN_VALUE;
            else value = Integer.MAX_VALUE;
            for (int i = 0; i < size; ++i) {
                TreeNode current = queue.poll();
                if (level % 2 == 0) {
                    if (current.val % 2 == 0) return false;
                    if (current.val <= value) return false;
                } else {
                    if (current.val % 2 != 0) return false;
                    if (current.val >= value) return false;
                }
                
                value = current.val;
                
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            
            level++;
        }
        
        return true;
    }
}