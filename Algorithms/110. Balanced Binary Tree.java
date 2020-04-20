/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        Recursion Bottom Up
    */
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        helper(root);
        return flag;
    }
    
    private int helper(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        if (Math.abs(left - right) > 1) flag = false;
        return Math.max(left, right) + 1;
    }
}