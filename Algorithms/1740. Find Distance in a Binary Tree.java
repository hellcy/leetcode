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
    public int findDistance(TreeNode root, int p, int q) {
        /*
            recursion
            find levels and sum up, or abs
        */
        if (p == q) return 0;
        return helper(root, p, q, 0);
    }
    
    private int helper(TreeNode node, int p, int q, int level) {
        int left = -1, right = -1;
        if (node.left != null) left = helper(node.left, p, q, level + 1);
        if (node.right != null) right = helper(node.right, p, q, level + 1);

        if (node.val == p) {
            if (left != -1 || right != -1) return left + right + 1 - level;
            else return level;
        } else if (node.val == q) {
            if (left != -1 || right != -1) return left + right + 1 - level;
            else return level;
        } else {
            if (left != -1) {
                if (right != -1) return (left - level) + (right - level);
                return left;
            }
            
            if (right != -1) {
                if (left != -1) return (left - level) + (right - level);
                return right;
            }
        }
        return -1;
    }
}