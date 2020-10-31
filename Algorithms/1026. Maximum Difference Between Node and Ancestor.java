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
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        /*
            pass down max and min
        */
        if (root == null) return 0;
        helper(root, root.val, root.val);
        
        return ans;
    }
    
    private void helper(TreeNode node, int min, int max) {
        ans = Math.max(ans, Math.abs(node.val - min));
        ans = Math.max(ans, Math.abs(node.val - max));
        //System.out.println(node.val + " " + min + " " + max);
        if (node.left != null) {
            if (node.val < min) {
                helper(node.left, node.val, max);
            } else if (node.val > max) {
                helper(node.left, min, node.val);
            } else {
                helper(node.left, min, max);
            }
        }
        
        if (node.right != null) {
            if (node.val < min) {
                helper(node.right, node.val, max);
            } else if (node.val > max) {
                helper(node.right, min, node.val);
            } else {
                helper(node.right, min, max);
            }
        }
    }
}