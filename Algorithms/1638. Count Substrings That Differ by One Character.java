class Solution {
    /*
        Trie store all substring of t and its number of ending occurance in a Trie
    */
    public class Trie {
        Trie[] children;
        int num;
        Trie() {
            num = 0;
            children = new Trie[256];
            for (Trie node : children) {
                node = null;
            }
        }
    }
    
    public int countSubstrings(String s, String t) {
        char[] ts = t.toCharArray();
        Trie head = new Trie();
        Trie current = head;
        for (int i = 0; i < t.length(); ++i) {
            for (int j = i + 1; j <= t.length(); ++j) {
                String str = t.substring(i, j);
                char[] cs = str.toCharArray();
                current = head;
                for (int k = 0; k < cs.length; ++k) {
                    char c = cs[k];
                    if (current.children[c] == null) {
                        Trie node = new Trie();
                        current.children[c] = node;
                    }
                    if (k == cs.length - 1) current.children[c].num++;
                    current = current.children[c];
                }
            }
        }

        
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                String str = s.substring(i, j);
                char[] cs = str.toCharArray();
                for (int k = 0; k < cs.length; ++k) {
                    char saved = cs[k];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == saved) continue;
                        cs[k] = c;
                        current = head;
                        boolean found = true;
                        for (char ch : cs) {
                            if (current.children[ch] != null) {
                                current = current.children[ch];
                            } else {
                                found = false;
                                break;          
                            }
                        }

                        if (found) {
                            //System.out.println(str + " " + String.valueOf(cs) + " " + current.num);
                            count += current.num;
                        }
                    }
                    cs[k] = saved;
                }
            }
        }
        
        return count;
    }
}

/*
    HashMap method
    Slower than Trie
*/
class Solution {
    public int countSubstrings(String s, String t) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int sl = s.length();
        int tl = t.length();
        for (int i = 0; i < sl; ++i) {
            for (int j = i + 1; j <= sl; ++j) {
                String str = s.substring(i, j);
                map1.put(str, map1.getOrDefault(str, 0) + 1);
            }
        }
        
        for (int i = 0; i < tl; ++i) {
            for (int j = i + 1; j <= tl; ++j) {
                String str = t.substring(i, j);
                map2.put(str, map2.getOrDefault(str, 0) + 1);
            }
        }
        
        //System.out.println(map1);
        //System.out.println(map2);
        
        int count = 0;
        for (String key : map1.keySet()) {
            char[] cs = key.toCharArray();
            for (int i = 0; i < cs.length; ++i) {
                char saved = cs[i];
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (saved == c) continue;
                    cs[i] = c;
                    String target = String.valueOf(cs);
                    if (map2.containsKey(target)) {
                        count += map1.get(key) * map2.get(target);
                    }
                }
                cs[i] = saved;
            }
        }
        
        return count;
    }
}