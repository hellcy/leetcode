class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int row = accounts.length;
        int col = accounts[0].length;
        for (int i = 0; i < row; ++i) {
            int wealth = 0;
            for (int j : accounts[i]) {
                wealth += j;
            }
            max = Math.max(max, wealth);
        }
        
        return max;
    }
}