class Solution {
    public boolean canConstruct(String s, int k) {
        /*
            HashSet
                ignore characters that are in pair
                k must greater than the number of single characters
        */
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
                count++;
            }
        }
        
        
        
        if (k >= set.size() && k <= s.length()) {
            return true;
        } else return false;
    }
}