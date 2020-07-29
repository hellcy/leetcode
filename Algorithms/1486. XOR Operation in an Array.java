class Solution {
    public int xorOperation(int n, int start) {
        int[] array = new int[n];
        int ans = start;
        for (int i = 1; i < n; ++i) {
            array[i] = start + 2 * i;
            ans = ans ^ array[i];
        }
        
        return ans;
    }
}