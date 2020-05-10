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
    /*
        DFS binary tree
        add to set
    */
    boolean ans = false;
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Set<Integer> set = new HashSet<>();
        
        helper(root, k, set);
        return ans;
    }
    
    private void helper(TreeNode node, int k, Set<Integer> set) {
        if (ans || node == null) return;
        //System.out.println(node.val);
        set.add(node.val);
        if (node.val != k - node.val && set.contains(k - node.val)) ans = true;
        
        helper(node.left, k, set);
        helper(node.right, k, set);
    }
}