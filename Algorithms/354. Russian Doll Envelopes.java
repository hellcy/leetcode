class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        /*
            sequence dp
            O(n * n)
        */
         if (envelopes == null || envelopes.length == 0) return 0;
        
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });
        
//         int length = envelopes.length;
//         int[] dp = new int[length];
        
//         for (int i = 0; i < length; ++i) {
//             dp[i] = 1;
//             for (int j = 0; j < i; ++j) {
//                 if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);                    
//                 }
//             }
//         }
        
//         int max = 0;
//         for (int i : dp) {
//             max = Math.max(max, i);
//         }
        
//         return max;
        
        int length = envelopes.length;
        int max = 1;
        int maxwidth = envelopes[0][0], maxheight = envelopes[0][1];
        for (int i = 1; i < length; ++i) {
            if (envelopes[i][0] > maxwidth && envelopes[i][1] > maxheight) {
                max++;
                maxwidth = envelopes[i][0];
                maxheight = envelopes[i][1];
            }
        }
        return max;
    }
}