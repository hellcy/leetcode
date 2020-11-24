/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] helper(TreeNode node) {
        int[] left = new int[2];
        int[] right = new int[2];
        if (node.left != null) left = helper(node.left);
        if (node.right != null) right = helper(node.right);

        int[] ans = new int[2];
        // steal current node
        ans[0] = node.val;
        ans[0] += left[1];
        ans[0] += right[1];

        // do not steal
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return ans;
    }
}
// @lc code=end

