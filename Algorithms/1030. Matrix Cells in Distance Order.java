class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        /*
            PriorityQueue
        */
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> (Math.abs(x[0] - r0) + Math.abs(x[1] - c0)) - (Math.abs(y[0] - r0) + Math.abs(y[1] - c0)));
        
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                int[] temp = {i, j};
                heap.add(temp);
            }
        }
        
        int[][] ans = new int[R*C][2];
        for (int i = 0; i < R*C; ++i) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}