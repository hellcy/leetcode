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
        Recursion postorder
    */
//     List<Integer> list = new ArrayList<>();
//     public List<Integer> postorderTraversal(TreeNode root) {
//         helper(root);
//         return list;
//     }
    
//     private void helper(TreeNode node) {
//         if (node != null) {
//             if (node.left != null) helper(node.left);
//             if (node.right != null) helper(node.right);
//             list.add(node.val);
//         }
//     }
    
    /*
        Iterative postorder
            1. push to the left end
            2. check if right node exist, then repeat step 1
            3. if right node doesn't exist, we are at leaf node, add value then remove it from the tree
            
            Node removal rules: we are not sure if the node we want to remove is the left child or right child
            but if the parent node has left child, it must be left child. If parent node doesn't have left child
            then the node is its right child.
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            
            current = stack.peek();
            current = current.right;
            if (current == null) {
                current = stack.pop();
                //System.out.println(current.val);
                list.add(current.val);
                if (!stack.isEmpty()) {
                    current = stack.peek();
                    if (current.left != null) current.left = null;
                    else current.right = null;
                }
                current = null;
            }
        }
        
        return list;
    }

}