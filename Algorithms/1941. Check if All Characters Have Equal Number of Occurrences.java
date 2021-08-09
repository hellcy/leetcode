class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count = 0;
        
        for (char key : map.keySet()) {
            if (count != 0 && map.get(key) != count) {
                return false;
            }
            count = map.get(key);
        }
        
        return true;
    }
}