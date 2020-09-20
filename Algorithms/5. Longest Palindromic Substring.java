class Solution {
    public String longestPalindrome(String s) {
        /*
            dp
            
            expand from the center points
        */
        if (s.length() == 0) return "";
        String ans = String.valueOf(s.charAt(0));
        int max = 1, length = s.length();
        boolean[][] dp = new boolean[length][length];
        
        for (int i = 0; i < length; ++i) {
            dp[i][i] = true;
        }
        
        char[] cs = s.toCharArray();
        for (int i = 0; i < length; ++i) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && cs[left] == cs[right]) {
                if (max < right - left + 1) {
                    max = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                
                left--;
                right++;
            }
        }
        
        for (int i = 0; i < length; ++i) {
            int left = i, right = i + 1;
            while (left >= 0 && right < length && cs[left] == cs[right]) {
                if (max < right - left + 1) {
                    max = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                
                left--;
                right++;
            }
        }
        
        return ans;
    }
}