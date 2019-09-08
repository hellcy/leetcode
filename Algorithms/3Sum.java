class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
            Algorithm explained:
                for each value in array, try to find two other values that add to minus that value
                using two sum as an assist
                pass the index + 1 so we don't reuse values
                sort the list so we don't add duplicate triplets
        */
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            twoSum(nums, nums[i], ans, i + 1);
        }
        return new ArrayList(ans);
    }
    
    public void twoSum(int[] nums, int target, Set<List<Integer>> set, int index) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = index; i < nums.length; ++i) {
            int second = -target - nums[i];
            if (map.containsKey(second) && map.get(second) != i) {
                List<Integer> list = new ArrayList<>();
                list.add(second);
                list.add(nums[i]);
                list.add(target);
                Collections.sort(list);
                set.add(list);
            } else {
                map.put(nums[i], i);
            }
        }
    }
}