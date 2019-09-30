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
        In order traverse
            visit nodes by ascending order
    */
    int smallsum = 0;
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        sum = sumtree(root);
        inorder(root);
        return root;
    }
    
    private int sumtree(TreeNode root) {
        if (root == null) return 0;
        else {
            return root.val + sumtree(root.left) + sumtree(root.right);
        }
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        
        inorder(node.left);
        
        int temp = sum - smallsum;
        smallsum += node.val;
        node.val = temp;

        inorder(node.right);
    }
}