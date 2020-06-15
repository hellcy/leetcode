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
        Recursion
        Bottom up
    */
    boolean ans = false;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        
        boolean left = false;
        
        if (root.left == null) left = true;
        else if (root.val == root.left.val && isUnivalTree(root.left)) left = true;
        
        boolean right = false;
                
        if (root.right == null) right = true;
        else if (root.val == root.right.val && isUnivalTree(root.right)) right = true;
        
        return left && right;
    }
}