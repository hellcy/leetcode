class Solution {
    public int[] minOperations(String boxes) {
        /*
            two pointers
        */
        char[] cs = boxes.toCharArray();
        int n = cs.length;
        int[] ans = new int[n];
        int left = 0, right = 0;

        int total = 0;
        for (int i = 1; i < n; ++i) {
            if (cs[i] == '1') {
                right++;
                total += i;
            }
        }

        ans[0] = total;
        for (int i = 1; i < n; ++i) {
            total -= right;
            if (cs[i] == '1') right--;
            if (cs[i - 1] == '1') left++;
            total += left;
            ans[i] = total;
        }

        return ans;
    }
}