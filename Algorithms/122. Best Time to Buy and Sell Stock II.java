class Solution {
    public int maxProfit(int[] prices) {
        /*
            Whenever there is a increase in the list, add it to the sum
        */
        if (prices.length <= 1) return 0;
        int sum = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}