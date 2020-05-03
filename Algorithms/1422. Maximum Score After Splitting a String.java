class Solution {
    public int maxScore(String s) {
        /*
            HashMap
            store number of zeros and ones into the map
            for each char, calculate the score if we choose to cut here
            return the max score we can get after looping the string
        */
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(0, 0);
        for (char c : s.toCharArray()) {
            if (c - '0' == 0) {
                map.put(0, map.get(0) + 1);
            } else {
                map.put(1, map.get(1) + 1);
            }
        }
        
        int max = 0, score = 0;
        int zero = 0, one = 0;
        // if (s.charAt(0) == '0') zero++;
        // else one++;
        for (int i = 0; i < s.length() - 1; ++i) {
            char c = s.charAt(i);
            if (c - '0' == 0) {
                zero++;
            } else {
                one++;
            }
            score = zero + map.get(1) - one;
            max = Math.max(max, score);
        }
        
        return max;
    }
}