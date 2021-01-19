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
        Construct BSTs
        Don't forget to check when start > end, and add null nodes to the trees
    */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> trees = new LinkedList<>();
        if (n == 0) return trees;

        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> trees = new LinkedList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }

        // loop through all possible root
        for (int i = start; i <= end; ++i) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode newroot = new TreeNode(i);
                    newroot.left = l;
                    newroot.right = r;
                    trees.add(newroot);
                }
            }
        }

        return trees;
    }
}