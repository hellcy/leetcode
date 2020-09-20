class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int row = n, column = n;
        
        int[] topleft = {0,0};
        int[] topright = {0, column - 1};
        int[] bottomleft = {row - 1, 0};
        int[] bottomright = {row - 1, column - 1};
        
        boolean[][] visited = new boolean[n][n];
        
        int current = 1;
        while (current < n * n) {
            for (int i = topleft[1]; i < topright[1]; ++i) {
                matrix[topleft[0]][i] = current;
                current++;
            }
            if (current > n * n) break;
            for (int i = topright[0]; i < bottomright[0]; ++i) {
                matrix[i][topright[1]] = current;
                current++;
            }
            if (current > n * n) break;
            for (int i = bottomright[1]; i > bottomleft[1]; --i) {
                matrix[bottomright[0]][i] = current;
                current++;
            }
            if (current > n * n) break;
            for (int i = bottomleft[0]; i > topleft[0]; --i) {
                matrix[i][bottomleft[1]] = current;
                current++;
            }
                        
            // update all coors
            topleft[0]++;
            topleft[1]++;
            
            topright[0]++;
            topright[1]--;
            
            bottomright[0]--;
            bottomright[1]--;
            
            bottomleft[0]--;
            bottomleft[1]++;
        }
        
        if (n % 2 != 0) matrix[n / 2][n / 2] = n * n;
        
        // for (int i2 = 0; i2 < n; ++i2) {
        //     for (int j2 = 0; j2 < n; j2++) {
        //         System.out.print(matrix[i2][j2] + " ");
        //     }
        //     System.out.println();
        // }
        
        return matrix;
    }
}