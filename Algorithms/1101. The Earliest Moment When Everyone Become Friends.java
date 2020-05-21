class Solution {
    public int earliestAcq(int[][] logs, int N) {
        /*
            Union find
            
            Sort the array by timestamp and connect them one by one until they all meet each other
        */
        
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        
        int[] array = new int[N];
        for (int i = 0; i < N; ++i) {
            array[i] = i;
        }
        
        for (int i = 0; i < logs.length; ++i) {
            int root_a = find(array, logs[i][1]);
            int root_b = find(array, logs[i][2]);
            if (root_a != root_b) {
                array[root_a] = root_b;
                N--;
                if (N == 1) return logs[i][0];
            }
        }
        
        return -1;
    }
    
    private int find(int[] array, int x) {
        if (array[x] == x) return x;
        return array[x] = find(array, array[x]);
    }
}