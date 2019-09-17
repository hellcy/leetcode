class Solution {
    public boolean isSubsequence(String s, String t) {
        /*
            Two Pointers
                start at index 0,
                if we found matching character, index++
                if all characters in string s were found, return true
        */
        int sstart = 0;
        int tstart = 0;
        
        int count = 0;
        while (sstart < s.length() && tstart < t.length()) {
            if (s.charAt(sstart) == t.charAt(tstart)) {
                sstart++;
                tstart++;
            } else tstart++;
        }
        
        if (sstart == s.length()) return true;
        else return false;
    }
}