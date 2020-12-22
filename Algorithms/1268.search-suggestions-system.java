/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
class Solution {
    class Trie {
        boolean isEnd;
        Trie[] children;
        Trie(char c) {
            this.isEnd = false;
            children = new Trie[26];
            for (int i = 0; i < children.length; ++i) {
                children[i] = null;
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        /*
            Trie + DFS
        */
        Trie root = new Trie();
        Trie cur = root;
        for (String str : products) {
            cur = root;
            for (char c : str.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Trie();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }

        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); ++i) {
            String temp = searchWord.substring(0, i + 1);

            List<String> list = new ArrayList<>();
            cur = root;
            boolean flag = false;
            for (char c : temp.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    lists.add(list);
                    flag = true;
                    break;
                }
                cur = cur.children[c - 'a'];
            }

            if (flag) {
                continue;
            }
        }
    }
}
// @lc code=end

