/*
 * @lc app=leetcode id=1329 lang=java
 *
 * [1329] Sort the Matrix Diagonally
 */

// @lc code=start
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int startrow = row - 1;
        while (startrow >= 0) {
            int curcol = 0;
            int currow = startrow;
            List<Integer> list = new ArrayList<>();

            while (currow < row && curcol < col) {
                list.add(mat[currow][curcol]);
                currow++;
                curcol++;
            }

            Collections.sort(list);

            currow = startrow;
            curcol = 0;
            int index = 0;
            while (currow < row && curcol < col) {
                mat[currow][curcol] = list.get(index);
                index++;
                currow++;
                curcol++;
            }

            startrow--;
        }

        int startcol = 1;
        while (startcol < col) {
            int curcol = startcol;
            int currow = 0;
            List<Integer> list = new ArrayList<>();

            while (currow < row && curcol < col) {
                list.add(mat[currow][curcol]);
                currow++;
                curcol++;
            }

            Collections.sort(list);

            currow = 0;
            curcol = startcol;
            int index = 0;
            while (currow < row  && curcol < col) {
                mat[currow][curcol] = list.get(index);
                currow++;
                curcol++;
                index++;
            }

            startcol++;
        }

        return mat;
    }
}
// @lc code=end

