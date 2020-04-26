class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        /*
            Simulation
        */
        if (matrix == null || matrix.length == 0) return new int[] {};
        int row = matrix.length, column = matrix[0].length;
        
        int[] array = new int[row * column];
        
        int x = 0, y = 0;
        boolean up = true;
        
        int index = 0;
        while (index != array.length) {
            if (up) {
                while (x >= 0 && y < column) {
                    if (x >= row || y < 0) {
                        y++;
                        x--;
                        continue;
                    }
                    array[index++] = matrix[x--][y++];
                }
                up = false;
                x = x + 1;
            } else {
                while (x < row && y >= 0) {
                    if (y >= column || x < 0) {
                        y--;
                        x++;
                        continue;
                    }
                    array[index++] = matrix[x++][y--];
                }
                up = true;
                y = y + 1;
            }
        }
        
        return array;
    }
}