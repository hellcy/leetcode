class Solution {
    public String generateTheString(int n) {
        /*
            StringBuilder
            Reminder %
        */
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n - 1; ++i) {
            ans.append('a');
        }
        
        if (n % 2 == 0) {
            ans.append('b');
            return ans.toString();
        } else {
            ans.append('a');
            return ans.toString();
        }
    }
}