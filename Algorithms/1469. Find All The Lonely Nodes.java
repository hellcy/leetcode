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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        helper(root, list);
        return list;
    }
    
    private int helper(TreeNode node, List<Integer> list) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        int left = helper(node.left, list);
        int right = helper(node.right, list);
        if (left + right == 1) {
            if (left == 1) list.add(node.left.val);
            else list.add(node.right.val);
        }
        return 1;
    }
}