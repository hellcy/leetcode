class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        /*
            Sliding window
            HashSet
        */
        int low = 0, high = 0;
        int count = 0;
        Set<Character> set = new HashSet<>();
        
        while (low < S.length() && high < S.length()) {
            if (!set.contains(S.charAt(high))) {
                set.add(S.charAt(high));
                high++;
            } else {
                while (S.charAt(low) != S.charAt(high)) {
                    set.remove(S.charAt(low));
                    low++;
                }
                set.remove(S.charAt(low));
                low++;
            }
            
            if (set.size() == K) {
                set.remove(S.charAt(low));
                low++;
                count++;
            }
        }
        
        return count;
    }
}