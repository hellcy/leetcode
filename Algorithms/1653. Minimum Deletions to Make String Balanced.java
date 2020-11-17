class Solution {
    public int minimumDeletions(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        int numb = 0, numa = 0;
        for (int i = 0; i < n; ++i) {
            left[i] = numb;
            if (cs[i] == 'b') {
                numb++;
            }
        }
        
        for (int i = n - 1; i >= 0; --i) {
            right[i] = numa;
            if (cs[i] == 'a') {
                numa++;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            min = Math.min(min, left[i] + right[i]);
        }
        
        return min;
    }
}