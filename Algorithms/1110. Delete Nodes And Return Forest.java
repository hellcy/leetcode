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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) return ans;
        ans.add(root);
        
        helper(ans, root, null, to_delete);
        
        return ans;
    }
    
    private void helper(List<TreeNode> ans, TreeNode node, TreeNode parent, int[] arr) {
        if (node == null) return;
        int n = arr.length;
        TreeNode left = node.left;
        TreeNode right = node.right;
        for (int i = 0; i < n; ++i) {
            if (node.val == arr[i]) {
                if (ans.contains(node)) {
                    ans.remove(node);
                }
                if (left != null) {
                    ans.add(left);
                }
                if (right != null) {
                    ans.add(right);
                }
                if (parent != null) {
                    if (parent.left == node) parent.left = null;
                    else parent.right = null;   
                }
                break;
            }
        }
        
        
        helper(ans, left, node, arr);
        helper(ans, right, node, arr);
    }
}