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
        Bottom-Up
        Check leaf node's value and return true when we should remove it. And false when we should keep it
        Parent node will check both child nodes and itself
    */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        
        helper(root);
        
        return root;
    }
    
    private boolean helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            if (node.val == 0) return true;
            else return false;
        }
        
        boolean left = false, right = false;
        if (node.left != null) left = helper(node.left);
        else left = true;
        if (node.right != null) right = helper(node.right);
        else right = true;
        
        if (right) node.right = null;
        if (left) node.left = null;
        
        if (node.val == 1) return false;
        else if (node.left == null) return right;
        else if (node.right == null) return left;
        else return left && right;
    }
}