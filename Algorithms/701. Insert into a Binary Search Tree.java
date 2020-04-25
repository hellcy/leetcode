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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        /*
            BST
                insert node into a BST
        */
        insert(root, val);
        return root;
    }
    
    private void insert(TreeNode node, int val) {
        if (node.val < val) {
            if (node.right != null) {
                insert(node.right, val);
            } else {
                TreeNode newnode = new TreeNode(val);
                node.right = newnode;
            }
        } else {
            if (node.left != null) {
                insert(node.left, val);
            } else {
                TreeNode newnode = new TreeNode(val);
                node.left = newnode;
            }
        }
    }
}