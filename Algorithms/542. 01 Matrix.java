class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        /*
            BFS
            1. add all zeros to the queue first, mark them as visited
            2. start BFS level by level
        */
        
        if (matrix == null || matrix[0].length == 0) return matrix;
        int row = matrix.length, column = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (matrix[i][j] == 0)  {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int[] directionx = {-1, 0, 1, 0};
        int[] directiony = {0, 1, 0, -1};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; ++i) {
                int[] coors = queue.poll();
                
                for (int j = 0; j < 4; ++j) {
                    int coorx = coors[0] + directionx[j];
                    int coory = coors[1] + directiony[j];
                    
                    if (check(coorx, coory, matrix) && !visited[coorx][coory]) {
                        matrix[coorx][coory] = matrix[coors[0]][coors[1]] + 1;
                        
                        queue.add(new int[] {coorx, coory});
                        visited[coorx][coory] = true;
                    }
                }
            }
        }
        
        return matrix;
    }
    
    private boolean check(int x, int y, int[][] matrix) {
        int row = matrix.length, column = matrix[0].length;
        
        if (x < 0 || y < 0 || x >= row || y >= column) return false;
        return true;
    }
}