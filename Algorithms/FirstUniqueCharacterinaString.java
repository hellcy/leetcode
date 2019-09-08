class Solution {
    public int firstUniqChar(String s) {
        /*
            Store character and index information into a map
            if character appears more than once, remove it from the map and add it to set, 
            so we don't add it again
            return the char with the minimum index
        */ 
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!map.containsKey(c) && !set.contains(c)) {
                map.put(c, i);
            } else {
                set.add(c);
                map.remove(c);
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (Character c : map.keySet()) {
            min = Math.min(min, map.get(c));
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }
}