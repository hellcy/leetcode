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
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        /*
            DFS
        */
        
        if (root == null) return 0;
        helper(root, new ArrayList<>());
        
        return count;
    }
    
    private void helper(TreeNode node, List<Integer> list) {
        if (node.left == null && node.right == null) {
            //List<Integer> temp = new ArrayList<>(list);
            list.add(node.val);
            if (check(list)) count++;
            list.remove(list.size() - 1);
        } else {
            list.add(node.val);
            if (node.left != null) helper(node.left, list);
            if (node.right != null) helper(node.right, list);
            list.remove(list.size() - 1);
        }
    }
    
    private boolean check(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (int i : list) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        return set.size() <= 1;
    }
}