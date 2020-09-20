class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        
        int row = mat.length, col = mat[0].length;
        int[] rows = new int[row];
        int[] cols = new int[col];
        for (int i = 0; i < row; ++i) {
            int one = 0,  pos = -1;
            for (int j = 0; j < col; ++j) {
                if (mat[i][j] == 1) {
                    one++;
                    if (one == 1) pos = j;
                    else pos = -1;
                }
            }
            rows[i] = pos;
        }
        
        // for (int i : rows) {
        //     System.out.print(i + " ");
        // }
        
        for (int i = 0; i < col; ++i) {
            int one = 0, pos = -1;
            for (int j = 0; j < row; ++j) {
                if (mat[j][i] == 1) {
                    one++;
                    if (one == 1) pos = j;
                    else pos = -1;
                }
            }
            
            cols[i] = pos;
        }
        // for (int i : cols) {
        //     System.out.print(i + " ");
        // }
        for (int i = 0; i < row; ++i) {
            if (rows[i] == -1) continue;
            else {
                if (cols[rows[i]] == i) count++;
            }
        }
        
        return count;
    }
}