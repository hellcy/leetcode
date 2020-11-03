/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
    int max = 1;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[] {};
        Set<Integer> set = new HashSet<>();
        helper(root, set, 1, null);

        int[] ans = new int[set.size()];
        int index = 0;
        for (int i : set) {
            ans[index] = i;
            index++;
        }

        return ans;
    }

    private void helper(TreeNode node, Set<Integer> set, int cur, TreeNode prev) {
        if (node == null) return;
        if (prev == null || node.val != prev.val) {
            cur = 1;
        }
        else if (node.val == prev.val) {
            cur++;
        }

        if (cur > max) {
            set.clear();
            set.add(node.val);
        } else if (cur == max) {
            set.add(node.val);
        }

        max = Math.max(max, cur);

        helper(node.left, set, cur, node);
        helper(node.right, set, cur, node);

    }
}
// @lc code=end

