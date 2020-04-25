class Solution {
    /*
        Expand around center
            If we use brute force, we will use O(n2) to get all substrings and O(n) to see if each substirng is a palindrom
            Total running time will be O(n3)
            
            But if we start at each character and center between two characters
            Expand our substring from it to both sides, until it is not a palindrom, we could find the longest palindrom and
            all smaller palindrom start from that center point.
            Total running time will be O(n2)
    */
//     int index = 0, longest = 0;
//     public String longestPalindrome(String s) {
//         int start = 0, end = 0;
//         for (int i = 0; i < s.length(); ++i) {
//             helper(i, i, s);
//             helper(i, i + 1, s);
            
//         }
//         return s.substring(index, index + longest);
//     }
    
//     private void helper(int start, int end, String s) {
//         while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
//             start--;
//             end++;
//         }
//         if (longest < end - start - 1) {
//             longest = end - start - 1;
//             index = start + 1;
//         }
//     }
    
    /*
        Dynamic programming
            for each substring, check if the smaller substring is a palindrom by looking at the saved boolean
            checking start from right most, and substring start from smallest to longest
            
    */
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        
        int start = 0, end = 0;
        for (int i = length - 1; i >= 0; --i) {
            for (int j = i; j < length; ++j) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (end - start < j - i)) {
                    start = i;
                    end = j;
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
}