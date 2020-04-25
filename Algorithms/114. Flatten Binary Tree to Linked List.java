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
        Binary tree
        Divide and concour
    */
//     public void flatten(TreeNode root) {
//         helper(root);
//     }
    
//     private TreeNode helper(TreeNode node) {
//         if (node == null) return null;
//         if (node.left == null && node.right == null) return node;
//         TreeNode left = helper(node.left);
//         TreeNode right = helper(node.right);
        
//         node.left = null;
//         if (left != null) {
//             node.right = left;
//             //System.out.println(node.val);
//             while (left.right != null) {
//                 left = left.right;
//             }
//             left.right = right;
//         } else {
//             node.right = right;
//         }
        
//         return node;
//     }
    /*
        pre order traverse
    */
    TreeNode current = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        if (current != null) {
            current.left = null;
            current.right = root;
        }

        current = root;

        TreeNode rootRight = root.right; // keep track of this node, otherwise root.right will be changed after calling flatten function
        flatten(root.left);
        flatten(rootRight);
    }
}