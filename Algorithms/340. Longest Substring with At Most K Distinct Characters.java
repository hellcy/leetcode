class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        /*
            sliding window
        */
        // Map<Character, Integer> map = new HashMap<>();
        // if (s.length() <= 0 || k <= 0) return 0;
        // int max = Integer.MIN_VALUE;
        // int index = 0;
        // for (int i = 0; i < s.length(); ++i) {
        //     while (index < s.length() && map.size() <= k) {
        //         map.put(s.charAt(index), map.getOrDefault(s.charAt(index), 0) + 1);
        //         if (map.size() <= k) max = Math.max(max, index - i + 1);
        //         index++;
        //     }
            
        //     if (map.size() > k) {
        //         map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        //         if (map.get(s.charAt(i)) == 0) {
        //             map.remove(s.charAt(i));
        //         }
        //     }
        // }
        
        // return max;
        /*
            same as the method above
            but use array to store string instead of hashmap
        */
        if (s.length() <= 0 || k <= 0) return 0;
        int max = Integer.MIN_VALUE;
        int index = 0;
        
        int[] array = new int[256];
        int diffchar = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            while (index < s.length() && diffchar <= k) {
                char c = s.charAt(index);
                if(array[c] == 0) diffchar++;
                array[c]++;
                if (diffchar <= k) max = Math.max(max, index - i + 1);
                index++;
            }
            
            if (diffchar > k) {
                char c = s.charAt(i);
                array[c]--;
                if (array[c] == 0) {
                    diffchar--;
                }
            }
        }
        
        return max;
    }
}