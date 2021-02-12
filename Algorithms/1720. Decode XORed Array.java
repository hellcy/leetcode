class Solution {
    public int[] decode(int[] encoded, int first) {
        /*
            If you have:
                c = a^b;
            You can get a or b back if you have the other value available:
                a = c^b; // or b^c (order is not important)
                b = c^a; // or a^c
        */
        int length = encoded.length;
        int[] ans = new int[length + 1];
        ans[0] = first;
        int cur = first;
        for (int i = 1; i < ans.length; ++i) {
            ans[i] = cur ^ encoded[i - 1];
            cur = ans[i];
        }
        
        return ans;
    }
}