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
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if (root == null) return null;
        if (nodes.length == 1) return nodes[0];
        
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node);
        }
        
        return helper(root, set);
    }
    
    private TreeNode helper(TreeNode node, Set<TreeNode> set) {
        if (node == null) return null;
        
        TreeNode left = null, right = null;
        if (node.left != null) left = helper(node.left, set);
        if (node.right != null) right = helper(node.right, set);
        if (set.contains(node)) {
            return node;
        } else {
            if (left != null && right != null) return node;
            else if (left != null) return left;
            else if (right != null) return right;
            else return null;
        }
    }
}