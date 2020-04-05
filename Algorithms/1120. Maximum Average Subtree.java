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
        Binary tree
            Divide and concour
            Bottom up
    */
    double max = 0.0;
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0.0;
        
        int[] ans = helper(root);
        return max;
    }
    
    private int[] helper(TreeNode node) {
        if (node == null) return new int[] {0, 0};
        
        if (node.left == null && node.right == null) {
            max = Math.max(max, node.val/1.0);
            return new int[] {node.val, 1};
        }
        
        int[] leftarray = helper(node.left);
        int[] rightarray = helper(node.right);
        
        int[] array = new int[2];
        array[0] = leftarray[0] + rightarray[0] + node.val;
        array[1] = leftarray[1] + rightarray[1] + 1;
        max = Math.max(max, array[0]/(double)array[1]);
        
        return array;
    }
}