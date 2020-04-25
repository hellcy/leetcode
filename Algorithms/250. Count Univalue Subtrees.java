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
        Binary Tree
        Bottom-Up Recursion
            for each node, check their child nodes, if both uni-values, return the value
            if only one child node, check only one node's value
            if not both uni-values, return 0 as false
            
            0 -- false
            1 -- uni-value
            2 -- null
    */
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        
        int[] array = helper(root);
        return count;
    }
    
    private int[] helper(TreeNode node) {
        if (node == null) return new int[] {2, 0};
        
        if (node.left == null && node.right == null) {
            count++;
            return new int[] {1, node.val};
        }
        
        int[] leftarray = helper(node.left);
        int[] rightarray = helper(node.right);
        
        if (leftarray[0] == 1 && rightarray[0] == 1) {
            if (node.val == leftarray[1] && node.val == rightarray[1]) {
                count++;
                return new int[] {1, node.val};
            }
        } else if (leftarray[0] == 2 && rightarray[0] == 1) {
            if (node.val == rightarray[1]) {
                count++;
                return new int[] {1, node.val};
            }
        } else if (leftarray[0] == 1 && rightarray[0] == 2) {
            if (node.val == leftarray[1]) {
                count++;
                return new int[] {1, node.val};
            }
        }
        return new int[] {0, 0};
    }
}