class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /*
            Priority Queue
                store the k smallest number in a pq, greatest at top
                return the top number after traverse the whole matrix
        */
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                heap.add(matrix[i][j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        
        int ans = heap.poll();
        return ans;
    }
}