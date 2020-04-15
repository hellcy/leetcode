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
    public int findBottomLeftValue(TreeNode root) {
        /*
            level BFS
        */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode current = queue.poll();
                
                list.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        
        return list.get(0);
    }
}