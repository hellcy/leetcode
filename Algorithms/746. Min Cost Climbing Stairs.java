class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /*
            Algorithm explained:
                dynamic programming
                if f[i] is the final cost to climb to the top from step i. 
                Then f[i] = cost[i] + min(f[i+1], f[i+2]).
                return min from startCost and secondCost
        */
        int n = cost.length;
        for (int i = cost.length - 3; i >= 0; --i) {
            cost[i] = cost[i] + Math.min(cost[i + 1], cost[i + 2]);
        }
        
        return Math.min(cost[0], cost[1]);
    }
}