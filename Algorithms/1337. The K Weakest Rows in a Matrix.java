class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        /*
            Priority Queue with lambda expression
            Map
                first store number of soliders and their rows in a map
                the add map entry into a priority queue, with conditions
                    1. smaller number of soilders comes first
                    2. if number of soilders are the same, smaller rows comes first
        */
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((x, y) -> (x[1] == y[1]) ? x[0] - y[0] : x[1] - y[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int row = mat.length, column = mat[0].length;
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (mat[i][j] == 0) {
                    map.put(i, j);
                    break;
                } else if (j == column - 1) {
                    map.put(i, j + 1);
                }
            }
        }
        
        System.out.println(map);
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] array = new int[2];
            array[0] = entry.getKey();
            array[1] = entry.getValue();
            heap.add(array);
        }
        
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = heap.poll()[0];
        }
        
        return ans;
    }
}