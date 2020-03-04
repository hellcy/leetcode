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
        Binary Tree
        Top-Down Recursion
        update the target value
            if its zero and we are at leaf node, return true
            else return sub paths
    */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        int target = sum - root.val;
        
        if (target == 0 && root.left == null && root.right == null) return true;
        else {
            return hasPathSum(root.left, target) || hasPathSum(root.right, target);
        }
    }
}