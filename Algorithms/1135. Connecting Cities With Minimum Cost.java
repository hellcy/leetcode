class Solution {
    public int minimumCost(int N, int[][] connections) {
        /*
            Union find
        */
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        
        int[] array = new int[N + 1];
        
        for (int i = 1; i <= N; ++i) {
            array[i] = i;
        }
        
        int count = 0;
        for (int[] arr : connections) {
            int root_a = find(array, arr[0]);
            int root_b = find(array, arr[1]);
            if (root_a != root_b) {
                count += arr[2];
                array[root_a] = root_b;
                N--;
            }
        }
        
        if (N == 1) return count;
        return -1;
    }
    
    private int find(int[] array, int x) {
        if (array[x] == x) return x;
        return array[x] = find(array, array[x]);
    }
}