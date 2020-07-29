class Solution {
    public int numSplits(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //System.out.println(map);
        
        Set<Character> set2 = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            set2.add(c);
            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) map.remove(c);
            
            //System.out.println(map);
            //System.out.println(set2);
            
            if (set2.size() == map.size()) {
                ans++;
            }
        }
        
        return ans;
    }
}