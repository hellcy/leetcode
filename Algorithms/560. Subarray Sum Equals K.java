class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
            if the integers in the array could be negative, we need to use a hashmap to store the presum
            HashMap stores the presum and the times of occurence
            whenever we found sum - k in the map, we add the frequency to the count
        */
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // store sum == 0 to the map for the first subarray
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}