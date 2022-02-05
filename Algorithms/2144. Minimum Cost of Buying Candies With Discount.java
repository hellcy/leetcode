class Solution {
    public int minimumCost(int[] cost) {
        int total = 0;
        Arrays.sort(cost);
        
        int index = 1;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (index % 3 != 0) {
                total += cost[i];
            }
            index++;
        }
        
        return total;
    }
}