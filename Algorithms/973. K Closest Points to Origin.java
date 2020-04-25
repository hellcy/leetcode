class Solution {
    public int[][] kClosest(int[][] points, int K) {
        /*
            Priority Queue
        */
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> (y[0] * y[0] + y[1] * y[1]) - (x[0] * x[0] + x[1] * x[1]));
        for (int i = 0; i < points.length; ++i) {
            heap.add(points[i]);
            if (heap.size() > K) {
                heap.poll();
            }
        }
        
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = heap.poll();
        }
        
        return ans;
        
    }
}
