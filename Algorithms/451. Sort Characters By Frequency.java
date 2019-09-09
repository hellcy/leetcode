class Solution {
    public String frequencySort(String s) {
        /*
            HashMap
            Priority queue
                add character and its frequency to a map
                prioritise the characters by its frequency using a pq, greatest at top
                pop characters from pq one by one and add it to StringBuilder map.get(c) times
        */
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Character> heap = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
        
        for (char c : map.keySet()) {
            heap.add(c);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < map.size(); ++i) {
            char c = heap.poll();
            for (int j = 0; j < map.get(c); j++) {
                ans.append(c);
            }
        }
        
        return ans.toString();
    }
}