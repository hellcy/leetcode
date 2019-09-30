class Solution {
    public String removeOuterParentheses(String S) {
        /*
            Brute force
                find each primitive when count becomes zero
                remove outermost parenthese and add it a new string
        */
        int count = 0;
        int start = 0;
        String ans = "";
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                count++;
            } else if (S.charAt(i) == ')') {
                count--;
            }
            
            if (count == 0) {
                ans += S.substring(start+1, i);
                start = i + 1;
            }
        }
        return ans;
    }

}