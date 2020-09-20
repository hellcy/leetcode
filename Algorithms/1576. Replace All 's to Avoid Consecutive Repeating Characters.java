class Solution {
    public String modifyString(String s) {
        char left = '!', right = '!';
        char[] array = {'a', 'b', 'c'};
        
        StringBuilder str = new StringBuilder(s);
        
        for (int i = 0; i < str.length(); ++i) {
            left = '!';
            right = '!';
            char c = str.charAt(i);
            if (c != '?') continue;
            if (i == 0 && c == '?') {
                if (i + 1 < str.length()) {
                    right = str.charAt(i + 1);
                }
               str.setCharAt(i, helper(left, right, array)); 
            } else {
                left = str.charAt(i - 1);
                if (i + 1 < str.length()) right = str.charAt(i + 1);
                str.setCharAt(i, helper(left, right, array));
            }
        }
        
        return str.toString();
    }
    
    
    private char helper(char left, char right, char[] array) {
        for (char c : array) {
            if (c != left && c != right) return c;
        }
        
        throw null;
    }
}