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
        Binry Tree Recursion
        Top-Down 
    */
    int total = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        
        helper(root, 0, 0);
        return total;
    }
    
    private void helper(TreeNode node, int parent, int grandparent) {
        if (grandparent != 0 && grandparent % 2 == 0) {
            total += node.val;
        }
        
        if (node.left != null) {
            helper(node.left, node.val, parent);
        }
        
        if (node.right != null) helper(node.right, node.val, parent);
    }
}