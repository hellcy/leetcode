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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        
        List<Integer> list = new ArrayList<>();
        if (root == null || target == null) return list;
        
        helper(map, root, null);
        System.out.println(map);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target.val);
        
        int step = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int current = queue.poll();    
                if (step == K) {
                    list.add(current);
                }
                
                for (int neighbor : map.get(current)) {
                    if (visited.contains(neighbor)) continue;
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
            step++;
            if (step > K) break;
        }
        
        return list;
    }
    
    private void helper(Map<Integer, Set<Integer>> map, TreeNode node, TreeNode parent) {
        if (!map.containsKey(node.val)) {
            Set<Integer> set = new HashSet<>();
            map.put(node.val, set);
        }
        
        if (parent != null) {
            map.get(node.val).add(parent.val);
            map.get(parent.val).add(node.val);
        }
        
        if (node.left != null) helper(map, node.left, node);
        if (node.right != null) helper(map, node.right, node);
        
    }
}