class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        /*
            Priority Queue
            HashMap
                store the frequency information into a map
                keep add words into a pq, compare the words by frequency, smallest at top
                if frequencies are equal, compare words alphabetically
                
                add words into a list from heap, and reverse the list to let the word with highest frequency at front
        */
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> map.get(x).equals(map.get(y)) ? y.compareTo(x) : map.get(x) - map.get(y));
        
        for (String s : map.keySet()) {
            heap.add(s);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        
        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }
        Collections.reverse(ans); 
        return ans;
    }
}