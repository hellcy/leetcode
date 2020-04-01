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
    /*
        inorder traverse the BST, if we found the target value, the next node we visit is the answer
    */
    boolean found = false;
    TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        helper(root, p);
        return ans;
    }
    
    private void helper(TreeNode node, TreeNode p) {
        if (node.left != null) helper(node.left, p);
        
        if (node.val == p.val) {
            found = true;
        }
        else if (found && ans == null) {
            ans = node;
        }
        
        if (node.right != null) helper(node.right, p);
    }
}