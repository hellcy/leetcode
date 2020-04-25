class Solution {
    public int[] findErrorNums(int[] nums) {
        /*
            HashMap
        */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i :  nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[2];
        for (int i : map.keySet()) {
            if (map.get(i) == 2) ans[0] = i;
        }
        for (int i = 1; i <= nums.length; ++i) {
            if (!map.containsKey(i)) ans[1] = i;
        }
        return ans;
        
        /*
            Sort and set
        */
        // Arrays.sort(nums);
        // int[] ans = new int[2];
        // Set<Integer> set = new HashSet<>();
        // for(int i = 0; i < nums.length - 1; ++i) {
        //     if (nums[i] == nums[i + 1]) ans[0] = nums[i]; 
        //     set.add(nums[i]);
        // }
        // set.add(nums[nums.length - 1]);
        // for (int i = 1; i <= nums.length; ++i) {
        //     if (!set.contains(i)) ans[1] = i;
        // }
        // return ans;
    }
}