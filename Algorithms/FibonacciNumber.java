class Solution {
    public int fib(int N) {
        /*
            using array memoization
        */
        if (N == 0) return 0;
        int[] array = new int[N + 1];
        
        array[0] = 0;
        array[1] = 1;
        
        for (int i = 2; i <= N; ++i) {
            array[i] = array[i - 1] + array[i - 2];
        }
        
        return array[N];
    }
}