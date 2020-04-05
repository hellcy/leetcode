class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        /*
            Binary search
                keep doing binary search when sum == threshold because it may not be the smallest
        */
        Arrays.sort(nums);
        int start = 1, end = nums[nums.length - 1];
        
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            
            int sum = helper(nums, mid);
            //System.out.println(sum);
            if (sum == threshold) {
                end = mid;
            } else if (sum > threshold) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //System.out.println(start +  " " + end);
        //System.out.println(helper(nums, start));
        if (helper(nums, start) > threshold) return end;
        if (Math.abs(helper(nums, start) - threshold) >= Math.abs(helper(nums, end) - threshold)) return end;
        else return start;
    }
    
    private int helper(int[] nums, int value) {
        int sum = 0;
        for (int i : nums) {
            //System.out.println(value + " " + Math.ceil(i / (double)value));
            sum += Math.ceil(i / (double)value);
        }
        
        return sum;
    }
}