class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        /*
            Binary search
        */
        int min = 1;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
        }

        while (min + 1 < max) {
            int mid = (max - min) / 2 + min;
            if (helper(nums, mid, maxOperations)) {
                max = mid;
            } else {
                min = mid;
            }
        }
        //System.out.println(min + " " + max);
        if (helper(nums, min, maxOperations)) return min;
        else return max;
    }

    private boolean helper(int[] nums, int limit, int maxOperations) {
        for (int i : nums) {
            if (i > limit) {
                if (i % limit == 0) {
                    maxOperations -= (i / limit - 1);
                } else {
                    maxOperations -= i / limit;
                }
                if (maxOperations < 0) return false;
            }
        }
        return true;
    }
}