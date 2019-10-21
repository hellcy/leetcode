class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        /*
            Map
                store times information in a map and check if target value appears more than half of the length of the array
        */
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int length = nums.length;
        if (!map.containsKey(target)) return false;
        if (map.get(target) > length / 2) return true;
        else return false;
    }
}