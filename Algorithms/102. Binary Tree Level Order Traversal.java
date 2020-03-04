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
        Binary Tree
            Store each level in a list until list size is 0
    */
//     List<List<Integer>> lists = new ArrayList<>();
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<TreeNode> list = new ArrayList<>();
//         if (root != null) list.add(root);
//         helper(list);
//         return lists;
//     }
    
//     private void helper(List<TreeNode> list) {
//         if (list.size() == 0) return;
//         List<Integer> values = new ArrayList<>();
//         List<TreeNode> nodes = new ArrayList<>();
        
//         for (TreeNode node : list) {
//             values.add(node.val);
//             if (node.left != null) nodes.add(node.left);
//             if (node.right != null) nodes.add(node.right);
//         }
//         lists.add(values);
//         helper(nodes);
//     }
    
    /*
        Solution
        Queue
        Same logic 
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        TreeNode cur;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subAns = new LinkedList<Integer>();
            for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
                cur = q.poll();
                subAns.add(cur.val);                // visit the root
                if (cur.left != null) {
                    q.offer(cur.left);              // push left child to queue if it is not null
                }
                if (cur.right != null) {
                    q.offer(cur.right);             // push right child to queue if it is not null
                }
            }
            ans.add(subAns);
        }
        return ans;
    }
}