class Solution {
    public int minMoves(int[] nums) {
        /*
            same as decrease the maximum number by 1
        */

        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
        }

        int ans = 0;
        for (int i : nums) {
            ans += Math.abs(i - min);
        }

        return ans;
    }
}