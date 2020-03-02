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
        Recursive inorder
    */
//     List<Integer> list = new ArrayList<>();
//     public List<Integer> inorderTraversal(TreeNode root) {
//         helper(root);
//         return list;
//     }
    
//     private void helper(TreeNode root) {
//         if (root != null) {
//             if (root.left != null) {
//                 helper(root.left);
//             }
//             list.add(root.val);
//             helper(root.right);
//         }
//     }
    
    /*
        Iterative inorder
    */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>() {};
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // push to the left end
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            
            // add end node value, then check right
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        
        return list;
    }

}