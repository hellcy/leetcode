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
        Binary Tree Recursion
    */
    int total = 0;
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        helper(root);
        
        return total;
    }
    
    private void helper(TreeNode node) {
        total++;
        
        if (node.left != null) helper(node.left);
        if (node.right != null) helper(node.right);
    }
}