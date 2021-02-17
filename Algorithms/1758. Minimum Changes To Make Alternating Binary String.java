class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int count = 0;
        char[] cs = s.toCharArray();
        
        for (int i = 1; i < n; ++i) {
            if (cs[i] == cs[i - 1]) {
                count++;
                cs[i] = cs[i] == '1' ? '0' : '1';
            }
        }

        return Math.min(count, n - count);
    }
}