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
        Binary Tree Recursion
        1. make the recursion call first
        2. switch left child and right child, pay attention to null child situation
    */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        helper(root);
        return root;
    }
    
    private void helper(TreeNode root) {
        if (root.left != null) {
            helper(root.left);
            if (root.right == null) {
                root.right = root.left;
                root.left = null;
            } else {
                helper(root.right);
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
        }
        else if (root.right != null) {
            helper(root.right);
            if (root.left == null) {
                root.left = root.right;
                root.right = null;
            } else {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = temp;
            }
        }
    }
}