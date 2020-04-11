class Solution {
    public void wallsAndGates(int[][] rooms) {
        /*
            BFS
                for each gate, perform BFS
                update all empty rooms value with current gate, use a boolean matrix to keep track of visited rooms
                level by level increment the steps from current room to the current gate
                if value in the current room is greater then the current step, update it with the current step
                
                perform this BFS for all gates
                
        */
        if (rooms == null || rooms.length == 0) return;
        int row = rooms.length, column = rooms[0].length;
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }
    
    private void bfs(int[][] rooms, int x, int y) {
        int[] directionx = {-1, 0, 1, 0};
        int[] directiony = {0, 1, 0, -1};
        int row = rooms.length, column = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        
        boolean[][] visited = new boolean[row][column];
        
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] coors = queue.poll();
                visited[coors[0]][coors[1]] = true;
                for (int j = 0; j < 4; ++j) {
                    int coorx = coors[0] + directionx[j];
                    int coory = coors[1] + directiony[j];

                    if (coorx < 0 || coorx >= row || coory < 0 || coory >= column || visited[coorx][coory]) continue;
                    if (rooms[coorx][coory] != 0 && rooms[coorx][coory] != -1) {
                        if (rooms[coorx][coory] > step) {
                            rooms[coorx][coory] = step;
                        }
                        queue.add(new int[] {coorx, coory});
                    }
                }
            }
            step++;
        }
    }
}