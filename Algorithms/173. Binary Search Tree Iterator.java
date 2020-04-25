/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    /*
        inorder traverse the BST, keep track of the index of the current smallest number
    */
    List<Integer> list;
    int index;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        if (root != null) helper(root);
    }
    
    private void helper(TreeNode node) {
        if (node.left != null) helper(node.left);
        list.add(node.val);
        if (node.right != null) helper(node.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        int number = list.get(index);
        index++;
        return number;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return list.size() > index;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */