class Solution {
    public int countHomogenous(String s) {
        /*
            count each homogenous substring
            notice (1 + count) * count / 2 will exceed MAXINT so declare count as long then implicitly convert it to int
        */

        int n = s.length();
        char[] cs = s.toCharArray();
        long count = 1;
        int mod = (int)1e9 + 7;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < n; ++i) {
            if (cs[i] == cs[i - 1]) {
                count++;
            } else {
                ans += ((1 + count) * count / 2) % mod;
                count = 1;
            }
        }

        ans += ((1 + count) * count / 2) % mod;
        return ans;
    }
}