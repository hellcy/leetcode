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
        Bianry Tree
            In order traverse the bianry tree,
            and contruct it to a Increasing order search tree
    */
    List<Integer> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        
        helper(root);
        
        TreeNode head = new TreeNode(list.get(0));
        TreeNode current = head;
        for (int i = 1; i < list.size(); ++i) {
            TreeNode node = new TreeNode(list.get(i));
            current.right = node;
            current = current.right;
        }
        
        return head;
    }
    
    private void helper(TreeNode node) {
        if (node.left != null) helper(node.left);
        
        list.add(node.val);
        
        if (node.right != null) helper(node.right);
    }
}