class Solution {
    public int makeConnected(int n, int[][] connections) {
        /*
            Union find
            1. if number of cables is less than n - 1, we can't connect all of them, return -1
            2. calculate how many groups of computers are there. if it is x, then we need to move x - 1 cables to connect them into one group
        */
        if (connections.length < n - 1) return -1;
        
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = i;
        }
        
        
        
        int count = n;
        for (int i = 0; i < connections.length; ++i) {
            int root_a = find(array, connections[i][0]);
            int root_b = find(array, connections[i][1]);
            if (root_a != root_b) {
                array[root_a] = root_b;
                count--;
            }
        }
        
        return count - 1;
    }
    
    private int find(int[] array, int x) {
        if (array[x] == x) return x;
        
        return array[x] = find(array, array[x]);
    }
}