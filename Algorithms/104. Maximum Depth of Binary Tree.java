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
        Recursion
        Top-Down solution
    */
    int max = 1;
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        helper(root, max);
        return max;
    }
    
    private int helper(TreeNode node, int depth) {
        if (node.left != null) max = Math.max(helper(node.left, depth + 1), depth);
        if (node.right != null) max = Math.max(helper(node.right, depth + 1), depth);
        
        return Math.max(max, depth);
    }
    
    /*
        Recursion
        Bottom-Up solution
    */
//     public int maxDepth(TreeNode root) {
        
//     }
}