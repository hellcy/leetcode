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
        Keep track of the minimum number and maximum number of each subtree
        return false if any left subtree's max >= parent node or
        any right subtree's min <= parent node
    */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        
        int[] ans = helper(root);
        //System.out.println(ans[0] + " " + ans[1]);
        if (ans[0] == Integer.MAX_VALUE && ans[1] == Integer.MIN_VALUE) return false;
        else return true;
    }
    
    private int[] helper(TreeNode node) {
        if (node.left == null && node.right == null) return new int[] {node.val, node.val};
        
        int[] leftarray = new int[2];
        int[] rightarray = new int[2];
        if (node.left != null) {
            leftarray = helper(node.left);
            if ((leftarray[0] == Integer.MAX_VALUE && leftarray[1] == Integer.MIN_VALUE) || (leftarray[1] >= node.val)) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        if (node.right != null) {
            rightarray = helper(node.right);
            if ((rightarray[0] == Integer.MAX_VALUE && rightarray[1] == Integer.MIN_VALUE) || (rightarray[0] <= node.val)) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        
        if (node.left == null) return new int[] {node.val, rightarray[1]};
        else if (node.right == null) return new int[] {leftarray[0], node.val};
        else return new int[] {leftarray[0], rightarray[1]};
    }
}