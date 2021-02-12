class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int cur = 0;
        for (int i : gain) {
            cur += i;
            ans = Math.max(ans, cur);
        }
        
        return ans;
    }
}