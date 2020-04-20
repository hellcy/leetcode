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
        DFS
        Recursion Bottom up
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        return helper(p, q);
    }
    
    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        
        if (p.val != q.val) return false;
        
        return helper(p.left, q.left) && helper(p.right, q.right);
    }
}