class Solution {
    public int[] findBall(int[][] grid) {
        /*
            Simulation
            1. if grid value is 1, check its right cell's value
                1. if right cell is -1, stuck, check next
                2. if right cell is wall, stuck, check next
                3. if right cell is 1, keep checking bottom right cell
            2. if grid value is -1, similar logic applies
        */

        int row = grid.length;
        int col = grid[0].length;
        int[] ans = new int[col];
        for (int i = 0; i < col; ++i) {
            int curcol = i;
            int currow = 0;
            boolean stuck = false;
            while (currow < row) {
                if (grid[currow][curcol] == 1) {
                    if (curcol + 1 >= col || grid[currow][curcol + 1] == -1) {
                        ans[i] = -1;
                        stuck = true;
                        break;
                    }
                    curcol++;
                    currow++;
                }
                else if (grid[currow][curcol] == -1) {
                    if (curcol - 1 < 0 || grid[currow][curcol - 1] == 1) {
                        ans[i] = -1;
                        stuck = true;
                        break;
                    }
                    curcol--;
                    currow++;
                }
            }
            if (!stuck) {
                ans[i] = curcol;
            }
        }
        return ans;
    }
}