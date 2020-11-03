/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        
        TreeNode left = (root.val < min) ? null : lowestCommonAncestor(root.left, p, q);
        TreeNode right = (root.val > max) ? null : lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else if (right != null) return right;
        else return null;
    }
}
// @lc code=end

