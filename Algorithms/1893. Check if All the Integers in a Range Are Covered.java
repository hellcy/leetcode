class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // Brute force
        for (int i = left; i <= right; ++i) {
            boolean found = false;
            for (int[] range : ranges) {
                if (i >= range[0] && i <= range[1]) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        
        return true;
    }
}