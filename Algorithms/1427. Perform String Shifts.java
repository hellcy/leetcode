class Solution {
    public String stringShift(String s, int[][] shift) {
        // left shift and right shift can cancel out
        // don't forget to mod the answer as left or right shift can greater then the length
        
        int left = 0, right = 0;
        for (int i = 0; i < shift.length; ++i) {
            if (shift[i][0] == 0) left += shift[i][1];
            if (shift[i][0] == 1) right += shift[i][1];
        }
        
        int move = 0;
        if (left > right) {
            move = left - right;
            move = move % s.length();
            return s.substring(move) + s.substring(0, move);
        } else {
            move = right - left;
            move = move % s.length();
            return s.substring(s.length() - move) + s.substring(0, s.length() - move);
        }
    }
}