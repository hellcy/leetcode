/*
 * @lc app=leetcode id=655 lang=java
 *
 * [655] Print Binary Tree
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
    int height = 0;
    public List<List<String>> printTree(TreeNode root) {
        /*
            1. find height
            2. first queue to store node value
            3. second queue to store node position
        */
        List<List<String>> lists = new ArrayList<>();
        if (root == null) return lists;
        helper(root, 1);

        int n = 0;
        int level = height;
        int index = 0;
        while (level > 0) {
            n += Math.pow(2, index);
            index++;
            level--;
        }

        for (int i = 0; i < height; ++i) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                list.add("");
            }
            lists.add(list);
        }
        int mid = n / 2;
        //System.out.println(n);
        //System.out.println(lists.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(mid);
        level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                int cur2 = queue2.poll();
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    queue2.add(cur2 - (int)Math.pow(2, height - level - 2));
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    queue2.add(cur2 + (int)Math.pow(2, height - level - 2));
                }
                lists.get(level).set(cur2, String.valueOf(cur.val));

            }
            level++;
        }

        return lists;
    }

    private void helper(TreeNode node, int level) {
        height = Math.max(height, level);
        if (node.left != null) helper(node.left, level + 1);
        if (node.right != null) helper(node.right, level + 1);
    }
}
// @lc code=end

