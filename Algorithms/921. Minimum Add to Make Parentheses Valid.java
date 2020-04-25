class Solution {
    public int minAddToMakeValid(String S) {
        /*
            if count is zero, the parentheses are balanced, otherwise, count++ if we meet a '(' and count-- if we meet a ')'
            however, if we found a ')' before '(', that parenthese can not be balanced, so we add 1 to wrong.
            and add unbalanced count in the end
        */
        int count = 0;
        int wrong = 0;
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if (c == '(') count++;
            else if (c == ')') {
                if (count > 0) count--;
                else wrong++;
            }
        }
        
        return wrong + count;
    }
}