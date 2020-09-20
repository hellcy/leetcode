class Solution {
    public int binaryGap(int N) {
        int count = 1, max = 0;
        boolean flag = false;
        while (N >= 1) {
            if (N % 2 == 0) {
                if (flag) count++;
            } else {
                if (flag) max = Math.max(max, count);
                flag = true;
                count = 1;
            }
            N = N / 2;
        }
        
        return max;
    }
}