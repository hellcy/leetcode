class Solution {
    int sum = 0;
    public int pathSum(int[] nums) {
        /*
            count children nodes for each node
        */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int key = i / 10;
            int value = i % 10;
            map.put(key, value);
        }
        
        check(nums[0] / 10, map, 0);
        
        return sum;
    }
    
    private void check(int key, Map<Integer, Integer> map, int pathsum) {
        if (!map.containsKey(key)) return;
        pathsum += map.get(key);
        int level = key / 10;
        int position = key % 10;
        int left = (level + 1) * 10 + position * 2 - 1;
        int right = (level + 1) * 10 + position * 2;
        
        if (!map.containsKey(left) && !map.containsKey(right)) {
            sum += pathsum;
        }
        check(left, map, pathsum);
        check(right, map, pathsum);
    }
}