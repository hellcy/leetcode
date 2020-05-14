class Trie {
    /*
        Trie
    */
    class trieNode {
        trieNode[] array = new trieNode[26];
        boolean isEndOfWord;
        trieNode() {
            isEndOfWord = false;
            for (trieNode node : array) {
                node = null;
            }
        }
    }
    
    trieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new trieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        trieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.array[c - 'a'] == null) {
                trieNode newnode = new trieNode();
                node.array[c - 'a'] = newnode;
            }
            node = node.array[c - 'a'];
        }
        
        node.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        trieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.array[c - 'a'] == null) return false;
            node = node.array[c - 'a'];
        }
        if (!node.isEndOfWord) return false;
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        trieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.array[c - 'a'] == null) return false;
            node = node.array[c - 'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */