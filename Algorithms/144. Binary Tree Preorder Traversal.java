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
        Recursive preorder
    */
//     List<Integer> list = new ArrayList<>();
//     public List<Integer> preorderTraversal(TreeNode root) {
//         helper(root);
//         return list;
//     }
    
//     private void helper(TreeNode root) {
//         if (root != null) {
//             list.add(root.val);
//             helper(root.left);
//             helper(root.right);
//         }
//     }
    
    /*
        Interative preorder
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>() {};
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            ans.add(node.val);
            
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        
        return ans;
    }

}