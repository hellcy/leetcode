class Solution {
    /*
        Trie
    */
    class Trie {
        Trie[] children = new Trie[256];
        Trie() {
            for (Trie node : children) {
                node = null;
            }
        }
    }
    
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        Trie head = new Trie();
        Trie current = head;
        for (char c : pattern.toCharArray()) {
            Trie node = new Trie();
            current.children[c] = node;
            current = current.children[c];
        }   
        
        List<Boolean> list = new ArrayList<>();
        for (String str : queries) {
            current = head;
            boolean flag = false;
            int index = 0;
            for (char c : str.toCharArray()) {
                if (current.children[c] != null || c > 'Z') {
                    if (current.children[c] != null) {
                        index++;
                        current = current.children[c];
                    }
                    continue;
                } else {
                    list.add(false);
                    flag = true;
                    break;
                }
            }
            //System.out.println(index);
            if (!flag && index < pattern.length()) {
                for (int i = index; i < pattern.length(); ++i) {
                    if (pattern.charAt(i) <= 'Z') {
                        flag = true;
                        list.add(false);
                    }
                }
            }
            if (!flag) list.add(true);
        }
        
        return list;
    }
}