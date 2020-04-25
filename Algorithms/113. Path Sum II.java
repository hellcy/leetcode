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
        Binary Tree Recursion
        Top-Down
        1.keep track of target, when it hits zero, check if current node is a leaf node
        2.create a new list for each recursion call
    */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return lists;
        List<Integer> list = new ArrayList<>();
        helper(root, sum, list);
        
        return lists;
    }
    
//     private void helper(TreeNode node, int target, List<Integer> list) {
//         list.add(node.val);
        
//         if (target - node.val == 0 && node.left == null && node.right == null) {
//             lists.add(list);
//             return;
//         }
        
//         List<Integer> listleft = new ArrayList<>();
//         List<Integer> listright = new ArrayList<>();
        
//         for (int i : list) {
//             listleft.add(i);
//             listright.add(i);
//         }
        
//         if (node.left != null) helper(node.left, target - node.val, listleft);
//         if (node.right != null) helper(node.right, target - node.val, listright);
//     }
    
    /*
        Better solution
        Don't create new lists for each recursion call
        remove visited node from the list once we are done with it
    */
    private void helper(TreeNode node, int target, List<Integer> list) {
        list.add(node.val);
        
        if (target - node.val == 0 && node.left == null && node.right == null) {
            lists.add(new ArrayList<>(list));
        }
        
        if (node.left != null) helper(node.left, target - node.val, list);
        if (node.right != null) helper(node.right, target - node.val, list);
        
        // remove visited nodes
        list.remove(list.size() - 1);
    }
}