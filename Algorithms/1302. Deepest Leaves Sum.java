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
        Use a list to store sum of node values for each level
        Return the last value in the list
    */
    int level = 0;
    List<Integer> list = new ArrayList<>();
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        
        helper(root, 0);
        return list.get(list.size() - 1);
    }
    
    private void helper(TreeNode node, int level) {
        if (list.size() <= level) {
            list.add(node.val);
        } else {
            list.set(level, list.get(level) + node.val);     
        }
        
        if (node.left != null) helper(node.left, level + 1);
        if (node.right != null) helper(node.right, level + 1);
    }
}