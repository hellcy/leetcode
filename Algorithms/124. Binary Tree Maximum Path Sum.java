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
        Divide and conquer
        
    */
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        
        int value = helper(root);
        max = Math.max(max, value);
        return max;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        max = Math.max(max, node.val);
        
        int left = helper(node.left);
        int right = helper(node.right);
        max = Math.max(max, right + left + node.val);
        max = Math.max(max, Math.max(left, right) + node.val);
        //System.out.println(Math.max(left, right) + " " + node.val);
        return Math.max(Math.max(left, right) + node.val, node.val);
    }
}