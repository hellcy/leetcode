class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
            BFS
            Graph
            1. at each step, we get a list of strings that we could transform to 
            2. stop when we found the endWord
            
            Note: The hard part is to convert the wordList into a graph structure
            1. given a string, to find all eligible strings we can transform in the wordList, we consider change each character from a to z 
            2. for each character there are 26 ways. total of length * 26 ways, check if wordList contains this new String, if contains add it to the list
            3. Because List.contains takes O(n) to perform, convert the structure to Set, Set.contains takes O(1) to perform
            
            Update:
            1. now using a map to store all neighbors
        */
        
        if (wordList == null) return 0;
        if (beginWord.equals(endWord)) return 1;
        if (!wordList.contains(endWord)) return 0;
        
        Set<String> words = new HashSet<>();
        for (String str : wordList) {
            words.add(str);
        }
        
        words.add(beginWord);
        words.add(endWord);
        
        Map<String, Set<String>> map = getMap(words);
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        queue.add(beginWord);
        set.add(beginWord);
        
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; ++i) {
                String current = queue.poll();
                
                for (String neighbor : map.get(current)) {
                    if (neighbor.equals(endWord)) return count + 1;
                    if (!set.contains(neighbor)) {
                        queue.add(neighbor);
                        set.add(neighbor);
                    }
                }
            }
            count++;
        }
        
        
        
        return 0;
    }
    
    private Map<String, Set<String>> getMap(Set<String> words) {
        Map<String, Set<String>> map = new HashMap<>();
        
        for (String str : words) {
            map.put(str, new HashSet<>());
        }
        
        for (String str : words) {
            for (int i = 0; i < str.length(); ++i) {
                for (char c = 'a'; c <= 'z'; ++c) {
                    String newword = str.substring(0, i) + Character.toString(c) + str.substring(i + 1);
                    if (words.contains(newword)) {
                        map.get(str).add(newword);
                    }
                }
            }
        }
        return map;
    }
    
    // not used
    private List<String> getNeighbor(String current, Set<String> words) {
        List<String> list = new ArrayList<>();
        
        for (char c = 'a'; c <= 'z'; ++c) {
            for (int i = 0; i < current.length(); ++i) {
                if (c == current.charAt(i)) {
                    continue;
                }
                String neighbor = current.substring(0, i) + Character.toString(c) + current.substring(i + 1);
                if (words.contains(neighbor)) list.add(neighbor);
            }
        }
        
        return list;
    }
    
    // not used
    private String replace(String current, int i, char c) {
        char[] chars = current.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
}