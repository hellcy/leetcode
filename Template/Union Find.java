class Solution {
    public void UnionFind() {
        /*
        	Union Find template
        */
        
        // define union find array, at first, all elements only belongs to itself
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = i;
        }
        
    	// find if a and b are in the same group, then do proper calculation based on problem's requirement
        int root_a = find(array, a);
        int root_b = find(array, b);
        if (root_a != root_b) {
        	// either array[root_a] = root_b or array[root_b] = root_a are fine
            array[root_a] = root_b;
        }
    }
    
    // find method with path compression
    private int find(int[] array, int x) {
        if (array[x] == x) return x;
        
        return array[x] = find(array, array[x]);
    }
}