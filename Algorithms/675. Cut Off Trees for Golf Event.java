class Solution {
    /*
        BFS
        1. find all trees, store them in a list, sort the list
        2. use a map to store the position for trees
        3. for each tree we need to calculate the steps from current position to the next smallest tree, use BFS
    */
    int steps = 0;
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        
        int row = forest.size(), column = forest.get(0).size();
        
        int[][] board = new int[row][column];
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                board[i][j] = forest.get(i).get(j);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (board[i][j] > 1) {
                    list.add(board[i][j]);
                    map.put(board[i][j], new int[] {i, j});
                } 
            }
        }
        
        Collections.sort(list);
        int[] position = new int[] {0, 0};
        for (int i = 0; i < list.size(); ++i) {
            if (i == 0) {
                int[] temp = map.get(list.get(i));
                if (temp[0] == 0 && temp[1] == 0) continue;
            }
            if (i > 0) position = map.get(list.get(i - 1));
            int current = bfs(board, position, list.get(i), map);
            if (current == -1) return -1;
            else steps += current;
        }
        
        return steps;
    }
    
    private int bfs(int[][] board, int[] position, int index, Map<Integer, int[]> map) {
        int[] target = map.get(index);
        int row = board.length, column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        Queue<int[]> queue = new LinkedList<>();
        //System.out.println(position[0] + " "  + position[1] + " " + target[0] + " " + target[1] + " " + steps);

        queue.add(position);
        visited[position[0]][position[1]] = true;
        int steps = 0;
        int[] directionx = {0,1,0,-1};
        int[] directiony = {1,0,-1,0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] current = queue.poll();
                
                for (int j = 0; j < 4; ++j) {
                    int newx = current[0] + directionx[j];
                    int newy = current[1] + directiony[j];
                    if (newx == target[0] && newy == target[1]) return steps + 1;
                    int[] newp = new int[] {newx, newy};
                    
                    if (newx < 0 || newx >= row || newy < 0 || newy >= column || visited[newx][newy] || board[newx][newy] == 0) continue;
                    queue.add(newp);
                    visited[newx][newy] = true;
                }
            }
            steps++;
        }
        
        return -1;
    }
}