class Solution {
    public String maximumTime(String time) {
        char[] ans = new char[5];
        char[] cs = time.toCharArray();
        
        int index = 0;
        for (char c : cs) {
            if (c == '?') {
                if (index == 0) {
                    if (cs[1] == '?' || cs[1] - '0' < 4) ans[index] = '2';
                    else ans[index] = '1';
                }
                if (index == 4) ans[index] = '9';
                if (index == 3) ans[index] = '5';
                if (index == 1) {
                    if (ans[0] == '2') ans[index] = '3';
                    else ans[index] = '9';
                }
            } else {
                ans[index] = c;
            }
            index++;
        }
        
        return String.valueOf(ans);
    }
}