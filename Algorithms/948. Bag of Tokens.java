class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        /*
            greedy
        */
        
        Arrays.sort(tokens);
        
        int ans = 0;
        int left = 0, right = tokens.length - 1;
        int cur = 0;
        while (left <= right) {
            if (tokens[left] <= P) {
                P -= tokens[left];
                cur++;
                left++;
                ans = Math.max(ans, cur);
            } else if (cur >= 1) {
                P += tokens[right];
                cur--;
                right--;
            } else {
                break;
            } 
        }
        
        return ans;
    }
}