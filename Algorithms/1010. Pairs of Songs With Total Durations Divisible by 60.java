class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        /*
            Algorithm explained:
                store the number of songs with (length % 60) in a array with size 60
                the number of pairs with total length divisible by 60 is array[1] * array[59], array[2] * array[58]...
                for array[0] and array[30], we calculate them separately
        */
        int[] array = new int[60];
        for (int i = 0; i < time.length; ++i) {
            array[time[i] % 60]++;
        }
        int ans = 0;
        for (int i = 1; i < array.length / 2; ++i) {
            ans += array[i] * array[array.length - i];
        }
        int extra = 0;
        for (int i = 1; i < array[0]; ++i) {
            extra += i;
        }
        ans += extra;
        extra = 0;
        for (int i = 1; i < array[30]; ++i) {
            extra += i;
        }
        ans += extra;
        return ans;
    }
}