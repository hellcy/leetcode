/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        /*
            check each node after call helper function again, in case it becomes a leaf node
        */
        if (root == null) return null;
        
        
        helper(null, root, target);
        if (root.left == null && root.right == null && root.val == target) return null; 
        return root;
    }
    
    private void helper(TreeNode parent, TreeNode node, int target) {
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                if (parent.left == node) parent.left = null;
                else parent.right = null;
            }
        } else {
            if (node.left != null) helper(node, node.left, target);
            if (node.right  != null) helper(node, node.right, target);
            if (node.left == null && node.right == null) {
                if (node.val == target && parent != null) {
                    if (parent.left == node) parent.left = null;
                    else parent.right = null;
                }
            }
        }
        
        
    }
}