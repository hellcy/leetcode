class Solution {
    public int maxPower(String s) {
        /*
            Array
        */
        if (s.length() <= 0) return 0;
        int count = 1;
        int max = 1;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (prev == c) {
                count++;
                max = Math.max(max, count);
            } else {
                prev = c;
                count = 1;
            }
        }
        return max;
    }
}