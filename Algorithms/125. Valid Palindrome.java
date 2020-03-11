class Solution {
    /*
        StringBuilder
        ACSII table
    */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder(s);
        
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c < 48 || (c > 57 && c < 65) || (c > 90 && c < 97) || c > 122) {
                str.deleteCharAt(i);
                i--;
            }
        }
        //System.out.println(str);
        int n = str.length();
        for (int i = 0; i < n / 2; ++i) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}