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
        level BFS
    */
    public int minDepth(TreeNode root) {        
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; ++i) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null) {
                    return level;
                }
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            level++;
        }
        
        return level;
    }
}