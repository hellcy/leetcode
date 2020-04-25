class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {.
        /*
            Algorithm explained:
                sliding window
                calculate the sum of the current window, sliding to the end of the array
                keep track of the point
        */
        int sum = 0;
        int n = calories.length;
        for (int i = 0; i < k; ++i) {
            sum += calories[i];
        }
        
        int point = 0;
        if (sum < lower) point--;
        else if (sum > upper) point++;
        
        for (int i = k; i < n; ++i) {
            sum = sum + calories[i] - calories[i - k];
            if (sum < lower) point--;
            else if (sum > upper) point++;
        }
        
        return point;
    }
}