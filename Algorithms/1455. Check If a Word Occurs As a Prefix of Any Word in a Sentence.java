class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        /*
            Trie
        */
        class Trie {
            Trie[] children = new Trie[26];
            Trie() {
                for (Trie node : children) {
                    node = null;
                }
            }
        }
        
        String[] array = sentence.split(" ");
        Trie head = new Trie();
        Trie current = head;
        int index = 1;
        
        for (String str : array) {
            current = head;
            boolean flag = false;
            for (char c : str.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    Trie newnode = new Trie();
                    current.children[c - 'a'] = newnode;
                }
                current = current.children[c - 'a'];
            }
            
            current = head;
            for (char c : searchWord.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    flag = true;
                    break;
                }
                current = current.children[c - 'a'];
            }
            if (!flag) return index;
            index++;
        }
        
        return -1;
    }
}