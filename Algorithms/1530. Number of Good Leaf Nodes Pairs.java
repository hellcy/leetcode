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
    List<TreeNode> leafs = new ArrayList<>();
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    List<TreeNode> v = new ArrayList<>();
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        getLeafNodes(root);
        if (leafs.size() == 1) return 0;
        List<TreeNode> list = new ArrayList<>();
        graph.put(root, list);
        getGraph(root);
        
        //System.out.println(leafs);
        List<TreeNode> visited = new ArrayList<>();
        int index = 0;
        for (TreeNode node : leafs) {
            if (v.contains(node)) continue;
            dfs(leafs, node, index, distance, node, visited);
            v.add(node);
        }
        return count / 2;
    }
    
    private void getLeafNodes(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leafs.add(node);
        }
        getLeafNodes(node.left);
        getLeafNodes(node.right);
    }
    
    private void getGraph(TreeNode root) {
        List<TreeNode> list = graph.get(root);
        if (root.left != null) {
            list.add(root.left);
            List<TreeNode> left = new ArrayList<>();
            graph.put(root.left, left);
            left.add(root);
            getGraph(root.left);
        }
        if (root.right != null) {
            list.add(root.right);
            List<TreeNode> right = new ArrayList<>();
            graph.put(root.right, right);
            right.add(root);
            getGraph(root.right);
        }
    }
    
    private void dfs(List<TreeNode> list, TreeNode node, int index, int distance, TreeNode current, List<TreeNode> visited) {
        if (index <= distance && !visited.contains(current)) {
            if (node != current && list.contains(current)) {
                count++;
                return;
                //System.out.println(node.val + " " + current.val);
            }
            
            for (TreeNode treeNode : graph.get(current)) {
                visited.add(current);
                dfs(list, node, index + 1, distance, treeNode, visited);
                visited.remove(visited.size() - 1);
            }
        }
    }
}