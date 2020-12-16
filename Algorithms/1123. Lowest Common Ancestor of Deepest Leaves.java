/*
 * @lc app=leetcode id=1123 lang=java
 *
 * [1123] Lowest Common Ancestor of Deepest Leaves
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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        /*
            Same as Q.865
            1. Get list of deepest leaves nodes 
            2. Then Use Q.1676 approach to get answer
        */

        // get deepest level of tree
        if (root == null) return null;
        int level = getLevel(root, 0);
        // get deepest nodes
        Set<TreeNode> set = new HashSet<>();
        getNodes(root, 0, level, set);

        // get LCA of all deepest nodes
        return getLCA(root, set);
    }

    private int getLevel(TreeNode node, int level) {
        int left = 0, right = 0;
        if (node.left != null) left = getLevel(node.left, level + 1);
        if (node.right != null) right = getLevel(node.right, level + 1);
        return Math.max(level, Math.max(left, right));
    }

    private void getNodes(TreeNode node, int level, int maxLevel, Set<TreeNode> set) {
        if (level == maxLevel) {
            set.add(node);
        } else {
            if (node.left != null) getNodes(node.left, level + 1, maxLevel, set);
            if (node.right != null) getNodes(node.right, level + 1, maxLevel, set);
        }
    }

    private TreeNode getLCA(TreeNode node, Set<TreeNode> set) {
        TreeNode left = null, right = null;
        if (node.left != null) left = getLCA(node.left, set);
        if (node.right != null) right = getLCA(node.right, set);
        
        if (set.contains(node)) return node;
        else if (left != null && right != null) return node;
        else if (left != null) return left;
        else if (right != null) return right;
        else return null;
    }
}
// @lc code=end

