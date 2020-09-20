class Solution {
    public int minCost(String s, int[] cost) {
        int count = 0;
        if (s.length() < 2) return 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                if (cost[i - 1] <= cost[i]) count += cost[i - 1];
                else {
                    count += cost[i];
                    cost[i] = cost[i - 1];
                }
            }
        }
        
        return count;
    }
}