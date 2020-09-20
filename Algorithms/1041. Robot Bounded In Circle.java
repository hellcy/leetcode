class Solution {
    public boolean isRobotBounded(String instructions) {
         /*
            compare the final pos and the origin pos after the robot performed the whole instructions one round
            return true if:
            1 .directions changes
            2. still at 0, 0
         */
        
        char[] cs  = instructions.toCharArray();
        int curx = 0, cury = 0, curd = 1;
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] == 'G') {
                if (curd == 1) cury++;
                else if (curd == 2) curx++;
                else if (curd == 3) cury--;
                else if (curd == 4) curx--;
            } else if (cs[i] == 'L') {
                curd--;
                if (curd == 0) curd = 4;
            } else {
                curd++;
                if (curd == 5) curd = 1;
            }
        }
        
        if (curx == 0 && cury == 0) return true;
        else if (curd != 1) return true;
        return false;
    }
}