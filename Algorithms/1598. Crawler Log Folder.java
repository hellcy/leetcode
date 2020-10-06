class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (String str : logs) {
            if (str.equals("../")) {
                if (ans > 0) ans--;
            } else if (str.equals("./")) {
                
            } else {
                ans++;
            }
        }
        
        return ans;
    }
}