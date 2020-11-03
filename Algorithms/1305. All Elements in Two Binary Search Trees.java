/*
 * @lc app=leetcode id=1305 lang=java
 *
 * [1305] All Elements in Two Binary Search Trees
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        if (root1 != null) stack.add(root1);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            list.add(cur.val);
            if (cur.right != null) stack.add(cur.right);
            if (cur.left != null) stack.add(cur.left);
        }

        if (root2 != null) stack.add(root2);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            list.add(cur.val);
            if (cur.right != null) stack.add(cur.right);
            if (cur.left != null) stack.add(cur.left);
        }

        Collections.sort(list);
        return list;
    }
}
// @lc code=end

