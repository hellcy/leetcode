/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int prevcount = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int index = 0, start = 0;
            boolean flag = false;
            int count = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (flag) index++;
                if (cur != null) {
                    if (!flag) {
                        flag = true;
                        index = 1;
                        start = 1;
                    }
                    else {
                        start = index;
                    }
                    count++;
                    prevcount--;
                }

                if (cur == null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    if (cur.left != null) queue.add(cur.left);
                    else queue.add(null);
                    if (cur.right != null) queue.add(cur.right);
                    else queue.add(null);
                }

                if (prevcount == 0) break;
            }
            if (count == 0) break;
            else prevcount = count;
            max = Math.max(max, start);
        }

        return max;
    }
}
// @lc code=end

