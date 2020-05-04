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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        /*
            for each node in tree 1, check if there is a value == (target - current node value) in tree two
        */
        if (root1 == null) return false;
        
        int value = target - root1.val;
        return findvalue(root2, value) || twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }
    
    private boolean findvalue(TreeNode node, int value) {
        if (node == null) return false;
        if (node.val == value) return true;
        else if (node.val < value) {
            return findvalue(node.right, value);
        } else {
            return findvalue(node.left, value);
        }
    }
}