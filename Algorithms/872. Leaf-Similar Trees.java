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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root1 == null) return false;
        
        stack.add(root1);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            
            if (cur.left == null && cur.right == null) list1.add(cur.val);
            if (cur.right != null) stack.add(cur.right);
            if (cur.left != null) stack.add(cur.left);
        }
        
        if (root2 == null) return false;
        
        stack.add(root2);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            
            if (cur.left == null && cur.right == null) list2.add(cur.val);
            if (cur.right != null) stack.add(cur.right);
            if (cur.left != null) stack.add(cur.left);
        }
        
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); ++i) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        
        return true;
    }
}