class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        /*
            sum of subarray with negative numbers
            we need to use hashmap to store the presum and its index to calculate the subarray size
            
            if map already contains a presum, we don't update it with the new index since it will make the subarray shorter
        */
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                int temp = i - map.get(sum - k);
                if (temp > max) max = temp;
            }
            
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        
        return max;
    }
}