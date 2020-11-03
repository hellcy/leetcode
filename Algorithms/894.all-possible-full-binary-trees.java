/*
 * @lc app=leetcode id=894 lang=java
 *
 * [894] All Possible Full Binary Trees
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
    public List<TreeNode> allPossibleFBT(int N) {
        /*
            dfs
        */
        Set<TreeNode> set = new HashSet<>();
        List<TreeNode> list = new ArrayList<>();
        if (N % 2 == 0) return list;

        TreeNode root = new TreeNode(0);
        dfs(root, root, set, N - 1);

        for (TreeNode node : set) {
            list.add(node);
        }
        return list;
    }

    private void dfs(TreeNode root, TreeNode node, Set<TreeNode> set, int num) {
        if (num == 0) {
            set.add(copy(root));
        } else {
            TreeNode left = new TreeNode(0);
            TreeNode right = new TreeNode(0);

            node.left = left;
            node.right = right;
            if (num - 2 == 0) {
                dfs(root, node.left, set, num - 2);
            } else {
                dfs(root, node.left, set, num - 2);
                dfs(root, node.right, set, num - 2);
            }

            if (num >= 6) {
                dfs(root, node.left, set, num - 4);
                dfs(root, node.right, set, num - 4);
            }

            node.left = null;
            node.right = null;

        }
    }

    private TreeNode copy(TreeNode node) {
        if (node == null) return null;
        TreeNode newnode = new TreeNode(node.val);
        if (node.left != null) {
            newnode.left = copy(node.left);
        }
        if (node.right != null) newnode.right = copy(node.right);
        return newnode;
    }
}
// @lc code=end

