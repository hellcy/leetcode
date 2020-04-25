class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        /*
            Backtracking + BFS
            1. first do a BFS from endWord, calculate how many steps each word in wordList need to get to the endWord, store in a HashMap
            2. second do a backtracking DFS from startWord, every time check if next word is 1 more step closer to the endWord
            3. add all possible path to a list
            
            Note: You could also do a BFS from start to end then backtracking from end to start
            If you do both BFS and backtracking from the same start/end point, it takes longer time to perform.
            Because you could DFS to nodes that are further to the end point, but have the same distance to the start point. (check video)
        */
        
        Map<String, Integer> map = new HashMap<>();
        
        
        Set<String> words = new HashSet<>();
        
        for (String str : wordList) {
            words.add(str);
        }
        words.add(beginWord);
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(endWord);
        visited.add(endWord);
        map.put(endWord, 0);
        int step = 0, max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; ++i) {
                String current = queue.poll();
                
                for (String neighbor : getNeighbor(current, words)) {
                    if (!visited.contains(neighbor)) {
                        if (neighbor.equals(beginWord)) max = step + 1; 
                        queue.add(neighbor);
                        visited.add(neighbor);
                        map.put(neighbor, step + 1);
                    }
                }
            }
            step++;
        }
        
        List<List<String>> lists = new ArrayList<>();
        System.out.println(map);
        helper(lists, new ArrayList<String>(), map, max, words, "", beginWord);
        return lists;
    }
    
    private Set<String> getNeighbor(String current, Set<String> words) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < current.length(); ++i) {
            for (char c = 'a'; c <= 'z'; ++c) {
                String newword = current.substring(0, i) + Character.toString(c) + current.substring(i + 1);
                
                if (words.contains(newword)) set.add(newword);
            }
        }
        
        return set;
    }
    
    private void helper(List<List<String>> lists, List<String> list, Map<String, Integer> map, int max, Set<String> words, String prev, String beginWord) {
        //System.out.println(list);
        if (max == -1) {
            lists.add(new ArrayList<>(list));
        } else {
            for (String str : map.keySet()) {
                if (map.get(str) == max) {
                    if (str.equals(beginWord) || getNeighbor(prev, words).contains(str)) {
                        list.add(str);
                        helper(lists, list, map, max - 1, words, str, beginWord);
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
    }
}