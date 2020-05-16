class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        /*
            BFS
        */
        
        if (image == null || image.length == 0) return image;
        
        int row = image.length, column = image[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];
        
        queue.add(new int[] {sr, sc});
        visited[sr][sc] = true;
        int oldcolor = image[sr][sc];
        image[sr][sc] = newColor;
        
        int[] directionx = {-1, 0, 1, 0};
        int[] directiony = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] coors = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int coorx = coors[0] + directionx[i];
                int coory = coors[1] + directiony[i];
                
                if (coorx < 0 || coorx >= row || coory < 0 || coory >= column || visited[coorx][coory]) continue;
                if (image[coorx][coory] == oldcolor) {
                    image[coorx][coory] = newColor;
                    queue.add(new int[] {coorx, coory});
                    visited[coorx][coory] = true;
                }
            }
        }
        
        return image;
    }
}