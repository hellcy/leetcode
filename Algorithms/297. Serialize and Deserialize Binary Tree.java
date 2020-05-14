/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    /*
        BFS
    */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = "[";
        
        if (root == null) return ans + "]";
        
        // BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) ans += "null,";
            else ans += node.val + ",";
            
            if (node != null) queue.add(node.left);
            if (node != null) queue.add(node.right);
        }
        
        return ans.substring(0, ans.length() - 1) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        data = data.substring(1, data.length() - 1);
        if (data.length() == 0) return null;
        String[] array = data.split(",");
        
        // BFS
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(array[0]));
        queue.add(root);
        for (int i = 1; i < array.length; ++i) {
            TreeNode current = queue.poll();
            String leftstr = array[i];
            if (!leftstr.equals("null")) {
                TreeNode leftnode = new TreeNode(Integer.valueOf(leftstr));
                current.left = leftnode;
                queue.add(leftnode);
            }
            i++;
            String rightstr = array[i];
            if (!rightstr.equals("null")) {
                TreeNode rightnode = new TreeNode(Integer.valueOf(rightstr));
                current.right = rightnode;
                queue.add(rightnode);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));