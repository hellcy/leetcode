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
        Keep a list for each level, store nodes in a stack and check its size
    */
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return true;
        
        list.add(root.left);
        list.add(root.right);
        return helper(list);
    }
    
    private boolean helper(List<TreeNode> list) {
        List<TreeNode> newlist = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        for (TreeNode node : list) {
            if (node != null) newlist.add(node.left);
            if (node != null) newlist.add(node.right);
        }
        
        if (newlist.size() == 0) return true;

        for (int i = 0; i < list.size() / 2; ++i) {
            stack.add(list.get(i));
        }
                
        for (int i = list.size() / 2; i < list.size(); ++i) {
            TreeNode node = list.get(i);
            if (!stack.isEmpty()) {
                if (node == null && stack.peek() == null) stack.pop();
                else if (stack.peek() != null && node != null && stack.peek().val == node.val) stack.pop();
                else stack.add(node);
            } else {
                stack.add(node);
            }
        }
        
        //System.out.println(stack);
        //System.out.println(newlist.size());
        if (stack.size() == 0) {
            return helper(newlist);
        } else return false;
    }
}