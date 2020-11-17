/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        if (d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = root;
            return newroot;
        }

        while (!queue.isEmpty()) {
            if (level == d - 1) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            level++;
        }

        for (TreeNode node : queue) {
            TreeNode newleft = new TreeNode(v);
            TreeNode newright = new TreeNode(v);
            if (node.left != null) {
                newleft.left = node.left;
            }
            if (node.right != null) {
                newright.right = node.right;
            }
            node.left = newleft;
            node.right = newright;
        }

        return root;
    }
}
// @lc code=end

