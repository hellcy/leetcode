class Solution {
    public boolean canTransform(String start, String end) {
        /*
            Brute force
                Let's think of 'L' and 'R' as people facing left and right standing on one line, 
                and 'X' as an empty space on that line.
                1. 'L' and 'R' characters in the string can never cross each other
                2. the n-th 'L' can never go to the right of it's original position, 
                and similarly the n-th 'R' can never go to the left of it's original position. 
        */
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        
        int t = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) == 'L') {
                while (end.charAt(t) != 'L') {
                    t++;
                }
                if (i < t) return false;
                t++;
            }
        }
        
        t = 0;
        for (int i = 0; i < start.length(); ++i) {
            if (start.charAt(i) == 'R') {
                while (end.charAt(t) != 'R') {
                    t++;
                }
                if (i > t) return false;
                t++;
            }
        }
        
        return true;
    }
}