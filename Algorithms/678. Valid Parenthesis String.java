class Solution {
    public boolean checkValidString(String s) {
        /*
            Similar to normal valid parenthesis string
            But now we have a * symbol.
            Count the parenthesis depth and star count
            if we have more right parenthesis than left parenthesis, we need enough star to cancel it out, otherwise return false
            Do it again from the end of the string
        */
        int depth = 0, count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') depth++;
            else if (c == ')') depth--;
            else if (c == '*') count++;
            
            if (depth < 0) {
                if (count < -depth) return false;
            }
        }
        
        depth = 0;
        count = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);
            if (c == '(') depth++;
            else if (c == ')') depth--;
            else if (c == '*') count++;
            
            if (depth > 0) {
                if (count < depth) return false;
            }
        }
        
        return true;
    }
}