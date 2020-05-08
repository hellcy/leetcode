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
    /*
        return the level found node x or y
        compare with the current level, if the level difference is greater or equal than 2, we return true
        return false otherwise
    */
    boolean flag = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        
        helper(root, x, y, 1);
        return flag;
    }
    
    private int helper(TreeNode node, int x, int y, int level) {
        if (flag) return -1;
        if (node == null) return -1;
        
        int left = helper(node.left, x, y, level + 1);
        int right = helper(node.right, x, y, level + 1);
        
        if (left == -1 && right == -1) {
            if (node.val != x && node.val != y) return -1;
            if (node.val == x || node.val == y) return level;
        }
        
        if (left != -1 && right != -1) {
            if (left == right && Math.abs(level - left) >= 2) flag = true; 
        }
        
        if (left != -1) return left;
        if (right != -1) return right;
        
        return -1;
    }
}