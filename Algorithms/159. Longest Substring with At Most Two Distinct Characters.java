class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        /*
            Sliding window
        */
        // int index = 0;
        // int max = Integer.MIN_VALUE;
        
        // Map<Character, Integer> map = new HashMap<>();
        
        // for (int i = 0; i < s.length(); ++i) {
        //     while (index < s.length() && map.size() <= 2) {
        //         char c = s.charAt(index);
        //         map.put(c, map.getOrDefault(c, 0) + 1);
        //         if (map.size() <= 2) max = Math.max(max, index - i + 1);
        //         index++;
        //     }
            
        //     if (map.size() > 2) {
        //         char c = s.charAt(i);
        //         //System.out.println(c);
        //         map.put(c, map.get(c) - 1);
        //         if (map.get(c) == 0) {
        //             map.remove(c);
        //         }
        //     }
        // }
        
        // if (max == Integer.MIN_VALUE) return 0;
        // return max;
        /*
            Sliding window
            same as above but use array to store string instead of hashmap
        */
        int index = 0;
        int max = Integer.MIN_VALUE;
        
        int diffchar = 0;
        int[] array = new int[256];
        
        for (int i = 0; i < s.length(); ++i) {
            while (index < s.length() && diffchar <= 2) {
                char c = s.charAt(index);
                if (array[c] == 0) diffchar++;
                array[c]++;
                if (diffchar <= 2) max = Math.max(max, index - i + 1);
                index++;
            }
            
            if (diffchar > 2) {
                char c = s.charAt(i);
                array[c]--;
                if (array[c] == 0) {
                    diffchar--;
                }
            }
        }
        
        if (max == Integer.MIN_VALUE) return 0;
        return max;
    }
}