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
        Recursion
        Top down
        
        each time check the next value with its lower limit and upper limit,
        if next value is within the limit range, we could create a new node here and return
        otherwise return null
    */
    int index = 0;
    int[] preorder;
    int n;
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        n = preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int lower, int upper) {
        if (index == n) return null;
        
        int value = preorder[index];
        if (value < lower || value > upper) return null;
        
        TreeNode node = new TreeNode(value);
        
        index++;
        node.left = helper(lower, value);
        node.right = helper(value, upper);
        
        return node;
    }
}