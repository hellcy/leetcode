class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int count = 0;
        for (int i = 0; i < arr.length - m; ++i) {
            count = 0;
            for (int j = 0; j < arr.length; j = j + m) {
                if (check(arr, i, j, m)) {
                    count++;
                    if (count >= k) return true;
                } else {
                    count = 0;
                }
            }
        }
        
        return count >= k;
    }
    
    private boolean check(int[] arr, int start, int arrstart, int length) {
        //System.out.println(start + " " + arrstart);
        for (int i = start; i < start + length; ++i) {
            if (i + arrstart >= arr.length) return false;
            if (arr[i] != arr[i + arrstart]) return false;
        }
        
        return true;
    }
}