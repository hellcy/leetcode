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
        Brute force
            calculate all zigzag paths start from every node and return the max length
    */
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        
        helper(root, root, 0, 0);
        helper(root, root, 0, 1);
        return max;
    }
    
    // direction
    // 0 -> left
    // 1 -> right
    private void helper(TreeNode startNode, TreeNode node, int length, int direction) {
        if (node.left == null && node.right == null) {
            if (length > max) max = length;
            if (startNode.left != null) helper(startNode.left, startNode.left, 0, 0);
            if (startNode.right != null) helper(startNode.right, startNode.right, 0, 1);
        } else if (node.left == null && direction == 0) {
            if (length > max) max = length;
            if (startNode.left != null) helper(startNode.left, startNode.left, 0, 0);
            if (startNode.right != null) helper(startNode.right, startNode.right, 0, 1);
        } else if (node.right == null && direction == 1) {
            if (length > max) max = length;
            if (startNode.left != null) helper(startNode.left, startNode.left, 0, 0);
            if (startNode.right != null) helper(startNode.right, startNode.right, 0, 1);
        } else {
            if (node.left != null && direction == 0) helper(startNode, node.left, length + 1, 1);
            if (node.right != null && direction == 1) helper(startNode, node.right, length + 1, 0);
        }
    }
}