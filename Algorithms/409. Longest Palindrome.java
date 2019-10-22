class Solution {
    public int longestPalindrome(String s) {
        /*
            HashSet
                find all duplicate chars in the String, those can be add to the length
                then if set contains some chars, only one of those chars can be add to the length
        */
        int length = 0;
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                length += 2;
                set.remove(c);
            }
        }
        if (set.size() >= 1) return length + 1;
        else return length;
    }
}