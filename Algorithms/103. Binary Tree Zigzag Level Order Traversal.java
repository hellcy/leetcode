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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
            level BFS
        */
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < size; ++i) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            
            if (level % 2 == 0) {
                Collections.reverse(list);
                lists.add(list);
            }
            else lists.add(list);
            level++;
        }
        
        return lists;
    }
}