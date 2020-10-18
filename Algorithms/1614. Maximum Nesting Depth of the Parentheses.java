class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        
        char[] cs = s.toCharArray();
        
        int cur = 0;
        for (char c : cs) {
            if (c == '(') {
                cur++;
            } else if (c == ')') {
                cur--;
            }
            
            ans = Math.max(ans, cur);
        }
        
        return ans;
    }
}