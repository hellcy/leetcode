class Solution {
    public int characterReplacement(String s, int k) {
        /*
            similar to longest substring with at most k distinct characters
            
            keep track of the currentmax characters, all other characters will be change to this character.
            so max different characters is k (currentsum - currentmax <= k)
        */
        
        int index = 0;
        if (s.length() <= 0) return 0;
        int[] array = new int[26];
        int max = Integer.MIN_VALUE;
        int currentmax = 0, currentsum = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            while (index < s.length() && currentsum - currentmax <= k) {
                char c = s.charAt(index);
                array[c - 'A']++;
                currentsum += 1;
                currentmax = Math.max(currentmax, array[c - 'A']);
                if (currentsum - currentmax <= k) max = Math.max(max, index - i + 1);
                index++;
            }
            
            if (currentsum - currentmax > k) {
                char c = s.charAt(i);
                array[c - 'A']--;
                currentmax = Math.max(currentmax, array[c - 'A']);
                currentsum--;
            }
        }
        
        return max;
    }
}