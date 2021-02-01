class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] arr = new int[46];
        for (int i = lowLimit; i <= highLimit; ++i) {
            arr[helper(i)]++;
        }
        
        int ans = Integer.MIN_VALUE;
        for (int i : arr) {
            ans = Math.max(ans, i);
        }
        
        return ans;
    }
    
    private int helper(int num) {
        int ans = 0;
        while (num >= 1) {
            int cur = num % 10;
            ans += cur;
            num /= 10;
        }
        return ans;
    }
}