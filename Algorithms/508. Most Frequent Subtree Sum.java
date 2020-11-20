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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Long, Integer> map = new HashMap<>();
        
        if (root == null) return new int[] {};
        helper(root, map);
        List<Integer> list = new ArrayList<>();
        for (long key : map.keySet()) {
            if (map.get(key) == max) {
                list.add((int)key);
            }
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for (int i : list) {
            ans[index] = i;
            index++;
        }
        return ans;
    }
    
    private long helper(TreeNode node, Map<Long, Integer> map) {
        if (node == null) return Long.MAX_VALUE;
        long left = helper(node.left, map);
        long right = helper(node.right, map);
        
        long sum = 0;
        if (left != Long.MAX_VALUE) sum += left;
        if (right != Long.MAX_VALUE) sum += right;
        sum += node.val;
        if (!map.containsKey(sum)) {
            map.put(sum, 1);
        } else {
            map.put(sum, map.get(sum) + 1);
            max = Math.max(max, map.get(sum));
        }
        return sum;
    }
}