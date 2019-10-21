class Solution {
    public String reverseOnlyLetters(String S) {
        /*
            String
            String Builder
                use ascii table to check if a character is alphabetic
        */
        int start = 0, end = S.length() - 1;
        StringBuilder string = new StringBuilder(S);
        while (start < end) {
            //System.out.println(string.charAt(start) + " " + string.charAt(end));
            if (check(string.charAt(start)) && check(string.charAt(end))) {
                char temp = string.charAt(start);
                string.setCharAt(start, string.charAt(end));
                string.setCharAt(end, temp);
                start++;
                end--;
            } else if (!check(string.charAt(start))) {
                start++;
            } else if (!check(string.charAt(end))) {
                end--;
            }
        }
        
        return string.toString();
    }
    
    private boolean check(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
        else return false;
    }
}