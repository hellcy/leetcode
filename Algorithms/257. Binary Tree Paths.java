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
        Backtracking
    */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        
        helper(list, root, "");
        return list;
    }
    
    private void helper(List<String> list, TreeNode node, String str) {
        str += String.valueOf(node.val);
        if (node.left == null && node.right == null) {
            list.add(str);
        } else {
            if (node.left != null) {
                helper(list, node.left, str + "->");
                str.substring(str.length() - 1);
            }
            if (node.right != null) {
                helper(list, node.right, str + "->");
                str.substring(str.length() - 1);
            }
        }
    }
}