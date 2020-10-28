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
        pass the possible max and min value so we don't need to compare all values in the BST
        pay attention to the int overflow when node.val - min, min could be Integer.MIN_VALUE
    */
    int ans = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        return ans;
    }
    
    private void helper(TreeNode node, int min, int max) {
        if (node == null) return;
        
        if (node.left != null) {
            ans = Math.min(ans, Math.abs(node.left.val - node.val));
            ans = (int)Math.min(ans, Math.abs((long)node.left.val - min));
            helper(node.left, min, node.val);
        }
        if (node.right != null) {
            ans = Math.min(ans, Math.abs(node.right.val - node.val));
            ans = Math.min(ans, Math.abs(node.right.val - max));
            helper(node.right, node.val, max);
        }
    }
}