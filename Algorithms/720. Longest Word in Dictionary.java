class Solution {
    class Trie {
        boolean isEnd;
        Trie[] children;
        
        Trie() {
            isEnd = false;
            children = new Trie[26];
            for (Trie node : children) {
                node = null;
            }
        }
    }
    
    public String longestWord(String[] words) {
        /*
            Trie
        */
        Arrays.sort(words);
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        StringBuilder ans = new StringBuilder();
        String res = "";
        Trie head = new Trie();
        Trie current = head;
        
        for (String str : words) {
            current = head;
            boolean flag = false;
            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (current.children[c - 'a'] == null) {
                    Trie node = new Trie();
                    current.children[c - 'a'] = node;
                    if (i != str.length() - 1) flag = true;
                }
                current = current.children[c - 'a'];
                if (!flag) {
                    if (current.isEnd || (i == str.length() - 1)) 
                    {
                        ans.append(c);
                    }
                    else flag = true;
                }
            }
            //System.out.println(ans.toString());

            if (!flag && ans.length() > res.length()) {
                res = ans.toString();
            }
            ans = new StringBuilder();
            current.isEnd = true;
        }
        
        return res;
        
    }
}