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
        perform dfs on each node
    */
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        helper(root, sum, 0);
        return count;
    }
    
    private void helper(TreeNode node, int sum, int number) {
        if (node == null) return;
        dfs(node, sum, number);
        
        helper(node.left, sum, number);
        helper(node.right, sum, number);
    }
    
    private void dfs(TreeNode node, int sum, int number) {
        if (node == null) return;
        number += node.val;
        if (number == sum) {
            count++;
        }
        
        dfs(node.left, sum, number);
        dfs(node.right, sum, number);
    }
}