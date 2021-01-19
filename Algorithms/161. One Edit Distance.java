class Solution {
    public boolean isOneEditDistance(String s, String t) {
        /*
            similar to buddy strings
        */

        int sl = s.length();
        int tl = t.length();
        if (Math.abs(sl - tl) > 1.0) {
            return false;
        }

        if (sl > tl) {
            for (int i = 0; i < sl; ++i) {
                if ((s.substring(0, i) + s.substring(i + 1)).equals(t)) {
                    return true;
                }
            } 
        } else if (tl > sl) {
            for (int i = 0; i < tl; ++i) {
                if ((t.substring(0, i) + t.substring(i + 1)).equals(s)) {
                    return true;
                }
            } 
        } else {
            int count = 0;
            for (int i = 0; i < sl; ++i) {
                if (s.charAt(i) != t.charAt(i)) count++;
            }

            if (count == 0 || count > 1) return false;
            else return true;
        }
        return false;
    }
}