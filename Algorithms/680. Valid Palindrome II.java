class Solution {
    public boolean validPalindrome(String s) {
        /*
            String
        */
        String str1 = "", str2 = "";
        boolean flag = false;
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                flag = true;
                str1 = s.substring(0, i) + s.substring(i + 1);
                str2 = s.substring(0, s.length() - 1 - i) + s.substring(s.length() - i);
                break;
            }
        }
        
        if (!flag) return true;
        
        if (check(str1) || check(str2)) return true;
        else return false;
    }
    
    private boolean check(String s) {
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        
        return true;
    }
}