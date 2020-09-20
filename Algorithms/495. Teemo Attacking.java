class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0, endtime = 0;
        for (int i : timeSeries) {
            if (endtime > i) {
                ans -= endtime - i;
            }
            
            ans += duration;
            endtime = i + duration;
        }
        
        return ans;
    }
}