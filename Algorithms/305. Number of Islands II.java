class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        /*
            Union find
            1. use 1d array as the structure of union find. Know how to convert 2d coordinates to 1d and store it in the array
            2. after each position check if the current position has any neighbors that are already island
        */
        List<Integer> list = new ArrayList<>();
        if (positions == null) return list;
        
        int[] array = new int[m * n];
        int row = m, column = n;
        for (int i = 0; i < array.length; ++i) {
            array[i] = i;
        }
        
        int[][] isIsland = new int[m][n];
        
        int[] directionx = {-1, 0, 1, 0};
        int[] directiony = {0, 1, 0, -1};
        int count = 0;

        for (int i = 0; i < positions.length; ++i) {
            if (isIsland[positions[i][0]][positions[i][1]] == 1) {
                list.add(count);
                continue;
            }
            isIsland[positions[i][0]][positions[i][1]] = 1;
            count++;
            
            //check if its neighbors are already island
            for (int j = 0; j < 4; ++j) {
                int coorx = positions[i][0] + directionx[j];
                int coory = positions[i][1] + directiony[j];
                
                if (coorx < 0 || coorx >= row || coory < 0 || coory >= column || isIsland[coorx][coory] == 0) continue;
                
                int id_new = positions[i][0] * column + positions[i][1];
                int id_neighbor = coorx * column + coory;
                int root_new = find(array, id_new);
                int root_neighbor = find(array, id_neighbor);
                
                if (root_new != root_neighbor) {
                    count--;
                    array[root_new] = root_neighbor;
                }
            }
            list.add(count);
        }
        
        return list;
    }
    
    private int find(int[] array, int x) {
        if (array[x] == x) return x;
        return array[x] = find(array, array[x]);
    }
}