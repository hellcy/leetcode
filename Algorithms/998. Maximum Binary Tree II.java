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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        /*
            Pay attention to left and right!
        */
        TreeNode node = new TreeNode(val);
        if (val > root.val) {
            node.left = root;
            return node;
        } else {
            helper(root, null, node);
            return root;
        }
    }
    
    private void helper(TreeNode node, TreeNode parent, TreeNode target) {
        if (node.val > target.val) {
            if (node.right == null) {
                node.right = target;
            }
            else {
                helper(node.right, node, target);
            }
        } else {
            if (parent.left == node) {
                parent.left = target;
                target.left = node;
            } else {
                parent.right = target;
                target.left = node;
            }
        }
    }
}