class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Character> map2 = new HashMap<>();
        
        char[] cs = s.toCharArray();
        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        Set<Character> set = new HashSet<>();
        for (Character key : map.keySet()) {
            int freq = map.get(key);
            if (!map2.containsKey(freq)) {
                map2.put(freq, key);
                set.add(key);
            }
        }
        
        //System.out.println(set);
        
        int count = 0;
        for (Character key : map.keySet()) {
            if (set.contains(key)) continue;
            int freq = map.get(key);
            for (int i = freq - 1; i >= 0; --i) {
                if (i == 0) count += freq;
                else if (!map2.containsKey(i)) {
                    count += freq - i;
                    map2.put(i, key);
                    break;
                }
            }
        }
        
        return count;
    }
}