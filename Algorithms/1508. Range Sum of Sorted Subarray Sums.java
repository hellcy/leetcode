class Solution {
    int index = 0;
    int[] array;
    public int rangeSum(int[] nums, int n, int left, int right) {
        /*
            Array
            Sort
        */
        int mod = (int)(1e9 + 7);
        array = new int[n * (n + 1) / 2];
        for (int i = 0; i < n; ++i) {
            array[index] = nums[i];
            int sum = nums[i];
            index++;
            for (int j = i + 1; j < n; ++j) 
            {
                sum = (sum + nums[j] % mod) % mod;
                array[index] = sum;
                index++;
            }
        }
        
        Arrays.sort(array);
        
        int ans = 0;
        for (int i = left - 1; i < right; ++i) {
            ans += array[i] % mod;
            ans = ans % mod;
        }
        
        return ans;
    }
}