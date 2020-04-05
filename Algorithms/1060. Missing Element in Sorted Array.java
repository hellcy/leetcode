class Solution {
    public int missingElement(int[] nums, int k) {
        /*
            Binary search
                calculator what the number should be at the current index, 
                then we can know how many numbers have been missing so far
                compare it with k we know where the kth missing number locate
                we the final interval and see if it exceed right limit, if it is we plus 1 to the answer
        */
        int length = nums.length;
        
        int start = 0, end = length - 1;
        
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            int should = mid + nums[0];
            if (nums[mid] - should == k) {
                return nums[mid] - 1;
            } else if (nums[mid] - should > k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        //System.out.println(start + " " + end);
        //System.out.println(nums[start] + " " + nums[end]);
        //System.out.println(k - (nums[start] - start - nums[0]));
        
        int should = k - (nums[start] - start - nums[0]);
        if (nums[start] + should >= nums[end]) return nums[start] + should + 1;
        return nums[start] + should;
        
    }
}