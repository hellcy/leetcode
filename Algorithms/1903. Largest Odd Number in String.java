class Solution {
    public String largestOddNumber(String num) {
        // check from the end of the string, look for the first number that is odd
        char[] chars = num.toCharArray();
        for (int i = chars.length - 1; i >= 0; --i) {
            char c = chars[i];
            if ((c - '0') % 2 != 0) return num.substring(0, i + 1);
        }
        
        return "";
    }
}