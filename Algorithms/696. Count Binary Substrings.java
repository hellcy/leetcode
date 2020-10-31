class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        int first = 1, second = 1;
        char[] cs = s.toCharArray();
        
        boolean isfirst = true;
        boolean flag = false;
        for (int i = 1; i < cs.length; ++i) {
            if (cs[i - 1] == cs[i]) {
                if (isfirst) {
                    first++;
                } else {
                    second++;
                }
            } else {
                if (!isfirst) {
                    ans += Math.min(first, second);
                    isfirst = !isfirst;
                    first = 1;
                }
                else if (isfirst) {
                    if (flag) ans += Math.min(first, second);
                    isfirst = !isfirst;
                    second = 1;
                }
                flag = true;
            }
        }
        
        if (flag) ans += Math.min(first, second);    
        return ans;
    }
}