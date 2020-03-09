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
    */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int max = Integer.MIN_VALUE;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        
        TreeNode node = new TreeNode(max);

        boolean flag = false;
        for (int i : nums) {
            if (!flag) {
                if (i < max) {
                    left.add(i);
                } else {
                    flag = true;
                    continue;
                }
            }
            
            if (flag) {
                right.add(i);
            }
        }
        
        int[] leftarray = new int[left.size()];
        int[] rightarray = new int[right.size()];
        for (int i = 0; i < leftarray.length; ++i) {
            leftarray[i] = left.get(i);
            //System.out.print(left.get(i));
        }
        //System.out.println();
        for (int i = 0; i < rightarray.length; ++i) {
            rightarray[i] = right.get(i);
            //System.out.println(right.get(i));
        }
        
        node.left = constructMaximumBinaryTree(leftarray);
        node.right = constructMaximumBinaryTree(rightarray);
        
        return node;
    }
}