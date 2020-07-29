class Solution {
    public int countOdds(int low, int high) {
        if (high == low) return (high % 2 == 0) ? 0 : 1;
        int count = 0;
        if (low % 2 == 1) count++;
        if (high % 2 == 1) count++;
        
        if (count == 0) {
            return (high - low - 1) / 2 + 1;
        } else if (count == 1) {
            return (high - low - 1) / 2 + 1;
        } else {
            return (high - low - 1) / 2 + 2;
        }
    }
}