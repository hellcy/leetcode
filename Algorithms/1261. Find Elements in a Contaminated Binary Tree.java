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
class FindElements {
    /*
        DFS
        Top Down
    */
    Set<Integer> set;
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        helper(root, 0);
    }
    
    private void helper(TreeNode node, int value) {
        if (node == null) return;
        node.val = value;
        set.add(value);
        helper(node.left, value * 2 + 1);
        helper(node.right, value * 2 + 2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */