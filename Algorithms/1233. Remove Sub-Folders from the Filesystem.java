/*
 * @lc app=leetcode id=1233 lang=java
 *
 * [1233] Remove Sub-Folders from the Filesystem
 */

// @lc code=start
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> list = new ArrayList<>();
        Arrays.sort(folder, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        Set<String> set = new HashSet<>();
        for (String str : folder) {
            boolean found = false;
            for (String str2 : set) {
                if (str2.length() > str.length()) continue;
                if (str2.equals(str.substring(0, str2.length())) && str.charAt(str2.length()) == '/') {
                    found = true;
                    break;
                }
            }
            if (!found) {
                set.add(str);
                list.add(str);
            }
        }
        return list;
    }

    /*
        TLE
        create N-ary tree to store all folders
        only add valid folders into the list
    */
    // class TreeNode {
    //     String val;
    //     boolean isEnd;
    //     Set<TreeNode> children;
    //     TreeNode(String val) {
    //         this.val = val;
    //         children = new HashSet<>();
    //         isEnd = false;
    //     }
    // }

    // public List<String> removeSubfolders(String[] folder) {
    //     TreeNode root = new TreeNode("root");
    //     for (String str : folder) {
    //         String[] names = str.split("/");
    //         addToTree(root, names, 0);
    //     }

    //     //printTree(root, 0);
    //     List<String> list = new ArrayList<>();
    //     for (TreeNode cur : root.children) {
    //         addToList(list, cur, "");
    //     }
    //     return list;
    // }

    // private void addToTree(TreeNode node, String[] names, int index) {
    //     if (index >= names.length) return;
    //     else {
    //         if (names[index].length() == 0) {
    //             addToTree(node, names, index + 1);
    //             return;
    //         }
    //         boolean found = false;
    //         for (TreeNode cur : node.children) {
    //             if (cur.val.equals(names[index])) {
    //                 if (index == names.length - 1) cur.isEnd = true;
    //                 addToTree(cur, names, index + 1);
    //                 found = true;
    //                 break;
    //             }
    //         }
    //         if (!found) {
    //             TreeNode newnode = new TreeNode(names[index]);
    //             if (index == names.length - 1) newnode.isEnd = true;
    //             node.children.add(newnode);
    //             addToTree(newnode, names, index + 1);
    //         }
    //     }
    // }

    // private void addToList(List<String> list, TreeNode node, String prefix) {
    //     if (node.isEnd) {
    //         list.add(prefix + "/" + node.val);
    //     } else {
    //         for (TreeNode cur : node.children) {
    //             addToList(list, cur, prefix + "/" + node.val);
    //         }
    //     }
    // }

    // private void printTree(TreeNode node, int level) {
    //     System.out.println(node.val + " " + level + " " + node.isEnd);
    //     for (TreeNode cur : node.children) {
    //         printTree(cur, level + 1);
    //     }
    // }
}
// @lc code=end

