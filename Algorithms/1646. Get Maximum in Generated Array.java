class Solution {
    public int getMaximumGenerated(int n) {
        int[] array = new int[n + 1];
        
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; ++i) {
            if (i % 2 == 0) {
                array[i] = array[i / 2];
            } else {
                array[i] = array[i / 2] + array[i / 2 + 1];
            }
        } 
        
        int max = 0;
        for (int i : array) {
            max = Math.max(max, i);
        }
        
        return max;
    }
}