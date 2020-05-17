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
        Binary Tree
        Recursion Top-Down
    */
    int count = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        
        helper(root, root.val);
        
        return count;
    }
    
    private void helper(TreeNode node, int max) {
        if (node.val >= max) count++;
        
        if (node.left != null) {
            helper(node.left, Math.max(max, node.left.val));
        }
        if (node.right != null) {
            helper(node.right, Math.max(max, node.right.val));
        }
    }
}