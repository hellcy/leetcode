class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int index = 0;
        for (int[] temp : queries) {
            int num = arr[temp[0]];
            for (int i = temp[0] + 1; i <= temp[1]; ++i) {
                num = num ^ arr[i];
            }
            ans[index] = num;
            index++;
        }
        return ans;
    }
}