class Solution {
    /*
        Math
    */
    public int minCostToMoveChips(int[] chips) {
        int countOdd = 0, countEven = 0;
        for (int i : chips) {
            if (i % 2 == 0) countEven++;
            else countOdd++;
        }
        
        return Math.min(countEven, countOdd);
    }
}