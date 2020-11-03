/*
 * @lc app=leetcode id=979 lang=java
 *
 * [979] Distribute Coins in Binary Tree
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
    int count = 0;
    public int distributeCoins(TreeNode root) {
        Map<TreeNode, Set<TreeNode>> adj = new HashMap<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if (cur.right != null) {
                if (!adj.containsKey(cur)) {
                    Set<TreeNode> set = new HashSet<>();
                    set.add(cur.right);
                    adj.put(cur, set);
                } else adj.get(cur).add(cur.right);
                if (!adj.containsKey(cur.right)) {
                    Set<TreeNode> rightset = new HashSet<>();
                    rightset.add(cur);
                    adj.put(cur.right, rightset);
                } else adj.get(cur.right).add(cur);
                
                stack.add(cur.right);
            }
            if (cur.left != null) {
                if (!adj.containsKey(cur)) {
                    Set<TreeNode> set = new HashSet<>();
                    set.add(cur.left);
                    adj.put(cur, set);
                } else adj.get(cur).add(cur.left);
                if (!adj.containsKey(cur.left)) {
                    Set<TreeNode> leftset = new HashSet<>();
                    leftset.add(cur);
                    adj.put(cur.left, leftset);
                } else adj.get(cur.left).add(cur);

                stack.add(cur.left);
            }
        }

        //System.out.println(adj);
        for (TreeNode node : adj.keySet()) {
            if (node.val == 1) continue;
            if (node.val > 1) {
                Set<TreeNode> visited = new HashSet<>();
                visited.add(node);
                dfs(node, node, adj, 1, visited);
            }
        }

        //System.out.println(adj);
        return count;
    }

    private void dfs(TreeNode node, TreeNode cur, Map<TreeNode, Set<TreeNode>> map, int step, Set<TreeNode> visited) {
        if (node.val == 1) return;
        else {
            //System.out.println(node.val);
            for (TreeNode n : map.get(cur)) {
                //System.out.println(n.val);
                if (visited.contains(n)) continue;
                visited.add(n);
                if (n.val == 0) {
                    n.val = 1;
                    node.val--;
                    count += step;
                    if (node.val == 1) return;
                }
                dfs(node, n, map, step + 1, visited);
            }
        }
    }
}
// @lc code=end

