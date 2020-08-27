class Solution {
    public int trapRainWater(int[][] heightMap) {
        /*
            heap + BFS
            最外面一圈当作墙壁
            从最小的一个格子开始，不断地用heap更新最小的值
            Time O(N * M * log (N * M))
            Space O(log (N * M))
        */
        class Cell {
            int x;
            int y;
            int h;
            Cell(int x, int y, int h) {
                this.x = x;
                this.y = y;
                this.h = h;
            }
        }
        
        class CellComparator implements Comparator<Cell> {
            public int compare(Cell x, Cell y) {
                return x.h - y.h;
            }
        }
        
        PriorityQueue<Cell> heap = new PriorityQueue<>((x, y) -> x.h - y.h);
        
        int row = heightMap.length, column = heightMap[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < column; ++i) {
            heap.add(new Cell(0, i, heightMap[0][i]));
            visited[0][i] = true;
            heap.add(new Cell(row - 1, i, heightMap[row - 1][i]));
            visited[row - 1][i] = true;
        }
        
        for (int i = 0; i < row; ++i) {
            heap.add(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            heap.add(new Cell(i, column - 1, heightMap[i][column - 1]));
            visited[i][column - 1] = true;
        }
        
        int ans = 0;
        int[] directionx = {-1, 0, 1, 0};
        int[] directiony = {0, 1, 0, -1};
        while (!heap.isEmpty()) {
            Cell current = heap.poll();
            
            for (int i = 0; i < 4; ++i) {
                int coorx = current.x + directionx[i];
                int coory = current.y + directiony[i];
                if (coorx < 0 || coorx >= row || coory < 0 || coory >= column || visited[coorx][coory]) continue;
                
                visited[coorx][coory] = true;
                heap.add(new Cell(coorx, coory, Math.max(current.h, heightMap[coorx][coory])));
                ans += Math.max(0, current.h - heightMap[coorx][coory]);
            }
        }
        
        return ans;
    }
}