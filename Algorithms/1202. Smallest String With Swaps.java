class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        /*
            1. Union find + PriorityQueue
            2. Union find + Double HashMap
        */
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] arr = new int[n];
        
        for (int i = 0; i < n; ++i) {
            arr[i] = i;
        }
        
        for (List<Integer> list : pairs) {
            int a_root = find(arr, list.get(0));
            int b_root = find(arr, list.get(1));
            if (a_root != b_root) {
                arr[a_root] = b_root;
            }
        }
        
        // pq is faster than using another map
//         Map<Integer, Map<Character, Integer>> map = new HashMap<>();
//         for (int i = 0; i < n; ++i) {
//             int root = find(arr, i);
//             if (!map.containsKey(root)) {
//                 Map<Character, Integer> valuemap = new HashMap<>();
//                 map.put(root, valuemap);
//             }
//             Map<Character, Integer> temp = map.get(root);
//             temp.put(cs[i], temp.getOrDefault(cs[i], 0) + 1);
//         }
                
//         for (int i = 0; i < n; ++i) {
//             int root = find(arr, i);
//             char min = 'z';
//             Map<Character, Integer> valuemap = map.get(root);
//             for (char key : valuemap.keySet()) {
//                 if (min > key) {
//                     min = key;
//                 }
//             }
//             cs[i] = min;
//             valuemap.put(min, valuemap.get(min) - 1);
//             if (valuemap.get(min) == 0) valuemap.remove(min);
//         }
        
        // using pq
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int root = find(arr, i);
            if (!map.containsKey(root)) {
                PriorityQueue<Character> pq = new PriorityQueue<>();
                map.put(root, pq);
            }
            map.get(root).add(cs[i]);
        }
        
        for (int i = 0; i < n; ++i) {
            int root = find(arr, i);
            cs[i] = map.get(root).poll();
        }
        
        return String.valueOf(cs);
    }
    
    private int find(int[] arr, int x) {
        if (arr[x] == x) return x;
        return arr[x] = find(arr, arr[x]);
    }
}