class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char ans = keysPressed.charAt(0);
        int time = releaseTimes[0];
        
        char[] cs = keysPressed.toCharArray();
        
        for (int i = 1; i < cs.length; ++i) {
            int curtime = releaseTimes[i] - releaseTimes[i - 1];
            char cur = cs[i];
            if (curtime > time) {
                time = curtime;
                ans = cur;
            } else if (curtime == time) {
                if (cur > ans) {
                    ans = cur;
                }
            }
        }
        
        return ans;
    }
}