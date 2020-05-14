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
        find target node, keep track of the path we took to get to here
        follow the same path in the cloned tree to find the answer node
    */
    List<Integer> list = new ArrayList<>();
    List<Integer> ans;
    TreeNode targetnode;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        targetnode = target;
        
        helper(original);
        
//         for (int i : ans) {
//             System.out.println(i);
//         }
        
        TreeNode ansnode = cloned;
        
        for (int i :  ans) {
            if (i == 0) ansnode = ansnode.left;
            else ansnode = ansnode.right;
        }
        return ansnode;
    }
    
    // 0 -> left
    // 1 -> right
    private void helper(TreeNode node) {
        if (node == targetnode) {
            ans = new ArrayList<>(list);
        }
        else if (node.left != null || node.right != null) {
            if (node.left != null) {
                list.add(0);
                helper(node.left);
                list.remove(list.size() - 1);
            }
            
            if (node.right != null) {
                list.add(1);
                helper(node.right);
                list.remove(list.size() - 1);
            }
            
        }
    }
}