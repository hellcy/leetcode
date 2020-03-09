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
        BST Recursion
    */
    TreeNode ans = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        helper(root, val);
        return ans;
    }
    
    private void helper(TreeNode node, int val) {
        if (node.val == val) ans = node;
        else {
            if (node.left != null) helper(node.left, val);
            if (node.right != null) helper(node.right, val);
        }
    }
}