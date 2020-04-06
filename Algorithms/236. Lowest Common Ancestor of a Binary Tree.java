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
        Divide and concour
            if p is at left subtree and q is at right subtree, the current root is the answer
            if p and q are both at left subtree, current left is the answer
            if p and q are both at right subtree, current right is the answer
            if p and q are not at any of the subtrees, return null
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        
        return null;
    }
}