class Solution {
    public int maxScore(int[] cardPoints, int k) {
        /*
            presum
        */
//         int left = 0, right = cardPoints.length - 1;
        
//         int[] leftsum = new int[cardPoints.length + 1];
//         int[] rightsum = new int[cardPoints.length + 1];
        
//         leftsum[1] = cardPoints[0];
//         for (int i = 2; i < leftsum.length; ++i) {
//             leftsum[i] = leftsum[i - 1] + cardPoints[i - 1];
//         }
        
//         rightsum[cardPoints.length - 1] = cardPoints[cardPoints.length - 1];
//         for (int i = cardPoints.length - 2; i >= 0; --i) {
//             rightsum[i] = rightsum[i + 1] + cardPoints[i];
//         }
        
        
// //         for (int i : rightsum) {
// //             System.out.print(i + " ");
// //         }

//         int max = 0;
//         for (left = 0; left < k; ++left) {
//             //System.out.println(cardPoints.length - (k - 1 - left));
//             max = Math.max(max, leftsum[left + 1] + rightsum[cardPoints.length - (k - 1 - left)]);
//         }

//         for (right = cardPoints.length - 1; right > cardPoints.length - 1 - k; --right) {
//             //System.out.println(k - (cardPoints.length - right));
//             max = Math.max(max, leftsum[k - (cardPoints.length - right)] + rightsum[right]);
//         }
        
//         return max;

        /*
            sliding window
            if we pick k cards from two sides, we could think we left a length - k window in the center
            presum the window and let it slide from left to right.
        */
        
        int length = cardPoints.length;
        int left = 0, right = length - k;
        int windowlength = right - left;
        
        int sum = 0;
        for (int i = 0; i < length; ++i) {
            sum += cardPoints[i];
        }
        
        // sum of initial window
        int windowsum = 0;
        for (int i = left; i < right; ++i) {
            windowsum += cardPoints[i];
        }
        
        int max = 0;
        while (right <= length) {
            if (left > 0) windowsum -= cardPoints[left - 1];
            max = Math.max(max, sum - windowsum);
            if (right < length) windowsum += cardPoints[right];
            left++;
            right++;
        }
        
        return max;
    }
}