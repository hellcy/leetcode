class WordDictionary {
    /*
        trie + DFS
    */
    
    class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;
        Trie() {
            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
        }
    }
    
    Trie head = new Trie();
    Trie current = head;
    /** Initialize your data structure here. */
    public WordDictionary() {
        current = head;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        current = head;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                Trie temp = new Trie();
                current.children[c - 'a'] = temp;
            }
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        current = head;
        return helper(word, current);
    }
    private boolean helper(String word, Trie current) {
        boolean ans = false;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Trie temp : current.children) {
                    if (temp != null) {
                        boolean res = helper(word.substring(i + 1), temp);
                        if (res) ans = res;
                    }
                }
                return ans;
            } else {
                if (current.children[c - 'a'] == null) return false;
                current = current.children[c - 'a'];
            }
        }
        
        if (current.isEnd) return true;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */