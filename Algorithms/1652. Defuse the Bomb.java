class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) return ans;
        for (int i = 0; i < n; ++i) {
            helper(code, ans, k, i);
        }
        
        return ans;
    }
    
    private void helper(int[] code, int[] ans, int k, int i) {
        int start = -1;
        int n = code.length;
        if (k > 0) {
            start = i + 1;
        } else {
            start = i + k;
            if (start < 0) start += n;
        }
        int num = 0;
        //System.out.println(start);
        int count = Math.abs(k);
        while (count > 0) {
            int temp = start % code.length;
            num += code[temp];
            start++;
            count--;
        }
        ans[i] = num;
    }
}