class Solution {
    public String removeKdigits(String num, int k) {
        /*
            StringBuilder
        */
        int length = num.length();
        StringBuilder str = new StringBuilder(num);
        int index = 0;
        
        int left = 0, right = 1, prev = 0;
        
        while (str.length() > right && k > 0) {
            int a = str.charAt(prev) - '0';
            int b = str.charAt(right) - '0';
            if (a > b) {
                str.deleteCharAt(prev);
                k--;
                prev--;
                right = prev + 1;
                if (prev < 0) {
                    prev = 0;
                    right = 1;
                }
            } else {
                prev++;
                right++;
            }
            
            while (str.length() > 0 && str.charAt(prev) - '0' == 0) {
                str.deleteCharAt(prev);
                
            }
        }
        String ans = str.toString();
        if (k > str.length()) return "0";
        if (k > 0) {
            ans = str.substring(0, str.length() - k);
        }
        
        if (ans.length() == 0) return "0";
        else return ans;
    }
}