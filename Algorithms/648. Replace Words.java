class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        /*
            Trie
        */
        
        class Trie {
            Trie[] children = new Trie[26];
            boolean isEnd;
            Trie() {
                for (Trie node : children) {
                    node = null;
                }
            }
        }
        
        Trie head = new Trie();
        Trie current = head;
        for (String str : dict) {
            current = head;
            for (char c : str.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    Trie newnode = new Trie();
                    current.children[c - 'a'] = newnode;
                }
                current = current.children[c - 'a'];
            }
            current.isEnd = true;
        }
        
        String[] array = sentence.split(" ");
        String ans = "";
        for (String str : array) {
            current = head;
            boolean flag = false;
            int index = 0;
            for (char c : str.toCharArray()) {
                if (current.isEnd) {
                    ans += str.substring(0, index) + " ";
                    flag = true;
                    break;
                }
                else if (current.children[c - 'a'] == null) {
                    ans += str + " ";
                    flag = true;
                    break;
                }
                current = current.children[c - 'a'];
                index++;
            }
            if (!flag) {
                ans += str + " ";
            }
        }
        return ans.substring(0, ans.length() - 1);
    }
}