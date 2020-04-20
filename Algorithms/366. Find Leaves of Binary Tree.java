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
        Recursion 
        Divide and conquer
    */
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        
        if (root == null) return lists;
        
        while (!helper(root)) {
            lists.add(new ArrayList<>(list));
            list = new ArrayList<>();
        }
        lists.add(list);
        return lists;
    }
    
    private boolean helper(TreeNode node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return true;
        } else {
            boolean left = helper(node.left);
            boolean right = helper(node.right);
            
            if (left) node.left = null;
            if (right) node.right = null;
            return false;
        }
    }
}