class Solution {
    public int findKthPositive(int[] arr, int k) {
        int index = 0, count = 0;
        for (int i = 1; i <= 1000; ++i) {
            if (index == arr.length) return k - count + i - 1;
            if (i == arr[index]) {
                index++;
            } else {
                count++;
            }
            
            if (count == k) return i;
        }
        
        return k - count + 1000;
    }
}