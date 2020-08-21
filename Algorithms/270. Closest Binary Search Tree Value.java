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
    double min = Double.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        
        return ans;
    }
    
    private void helper(TreeNode node, double target) {
        if (node == null) return;
        if (Math.abs(target - node.val) < min) {
            min = Math.abs(target - node.val);
            ans = node.val;
        }
        helper(node.left, target);
        helper(node.right, target);
    }
}