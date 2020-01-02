class Solution {
    public int scoreOfParentheses(String S) {
        /*
            Stack
                keep track of current parenthese depth(score)
                only add score to count if come across back parenthese first time
        */
        int count = 0;
        double score = 0.5;
        boolean check = true;
        char[] array = S.toCharArray();
        
        for (char c : array) {
            if (c == '(') {
                score = score * 2;
                check = true;
            } else {
                if (check) {
                    check = false;
                    count = count + (int)score;
                }
                score = score / 2;
            }
        }
        
        return count;
    }
}