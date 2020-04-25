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
        Backtracking
    */
    List<List<Integer>> lists = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        
        helper(root, new ArrayList<>());
        int sum = 0;
        for (List<Integer> list : lists) {
            //System.out.println(list);
            int value = 0;
            for (int i : list) {
                value *= 10;
                value += i;
            }
            sum += value;
        }
        
        return sum;
    }
    
    private void helper(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (node.left == null && node.right == null) {
            lists.add(new ArrayList<>(list));
        } else {
            if (node.left != null) {
                helper(node.left, list);
                list.remove(list.size() - 1);
            }
            if (node.right != null) {
                helper(node.right, list);
                list.remove(list.size() - 1);
            }
        }
    }
}