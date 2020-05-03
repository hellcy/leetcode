/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
        backtracking
        for each root to leaf path, check if it is the same as the array
    */
    boolean flag = false;
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) return false;
        
        helper(root, new ArrayList<Integer>(), arr);
        return flag;
    }
    
    private void helper(TreeNode node, List<Integer> list, int[] arr) {
        //System.out.println(list);
        if (flag) {
           return; 
        } else {
            if (node == null) {
                return;
            }
            else if (node.left == null && node.right == null) {
                list.add(node.val);
                flag = checkArray(new ArrayList<>(list), arr);
            } else {
                list.add(node.val);
                helper(node.left, new ArrayList<>(list), arr);
                helper(node.right, new ArrayList<>(list), arr);
            }
        }
    }
    
    private boolean checkArray(List<Integer> list, int[] arr) {
        int index = 0;
        if (list.size() != arr.length) return false;
        for (int i : list) {
            if (arr[index] != i) return false;
            index++;
        }
        
        return true;
    }
}