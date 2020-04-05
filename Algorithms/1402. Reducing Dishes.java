class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        /*
            remove negative numbers until the |sum of negatives| is smaller than the sum of positives
        */
        Arrays.sort(satisfaction);
        int possum = 0, negsum = 0, negcount = 0;
        for (int i = 0; i < satisfaction.length; ++i) {
            if (satisfaction[i] > 0) possum += satisfaction[i];
            else if (satisfaction[i] < 0) {
                negcount++;
                negsum += satisfaction[i];
            }
        }
        
        int count = 0;
        
        while (-negsum > possum) {
            negsum -= satisfaction[count];
            satisfaction[count] = 0;
            count++;
        }
        
        int ans = 0;
        for (int i = count; i < satisfaction.length; ++i) {
            ans += satisfaction[i] * (i + 1 - count);
        }
        return ans;
    }
}