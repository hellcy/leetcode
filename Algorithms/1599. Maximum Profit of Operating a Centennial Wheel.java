class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        /*
            Simple Simulation
            Running sum
        */
        int max = 0, current = 0;
        int count = 0;
        int ans = 0, currentRound = 0;
        
        for (int i : customers) {
            count += i;
            if (count >= 4) {
                current = current + boardingCost * 4 - runningCost;
                count -= 4;
            } else {
                current = current + boardingCost * count - runningCost;
                count = 0;
            }
            currentRound++;
            if (max < current) {
                max = current;
                ans = currentRound;
            }
        }
        
        while (count > 0) {
            if (count >= 4) {
                current = current + boardingCost * 4 - runningCost;
                count -= 4;
            } else {
                current = current + boardingCost * count - runningCost;
                count = 0;
            }
            currentRound++;
            if (max < current) {
                max = current;
                ans = currentRound;
            }
        }
        
        if (max <= 0) return -1;
        return ans;
    }
}