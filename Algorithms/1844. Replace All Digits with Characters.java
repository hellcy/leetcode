class Solution {
    public String replaceDigits(String s) {
        int length = s.length();
        char[] chars = new char[length];
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                chars[i] = c;
            } else {
                chars[i] = shift(s.charAt(i - 1), c - '0');
            }
        }
        
        return String.valueOf(chars);
    }
    
    private char shift(char c, int i) {
        return (char)(c + i);
    }
}