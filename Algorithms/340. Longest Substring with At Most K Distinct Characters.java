class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        /*
            sliding window
        */
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() <= 0 || k <= 0) return 0;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < s.length(); ++i) {
            while (index < s.length() && map.size() <= k) {
                map.put(s.charAt(index), map.getOrDefault(s.charAt(index), 0) + 1);
                if (map.size() <= k) max = Math.max(max, index - i + 1);
                index++;
            }
            
            if (map.size() > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
            }
        }
        
        return max;
    }
}