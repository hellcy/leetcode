class Solution {
    public int maxOperations(int[] nums, int k) {
        /*
            HashMap
            for x in nums, find how many (k - x) are in nums
            also find how many x are in nums
            ans += Math.min(map.get(x), map.get(k - x))
            
            if x == (k - x),
            ans += Math.floor(map.get(x) / 2);
        */
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        for (int key : map.keySet()) {
            if (!map.containsKey(k - key) || visited.contains(key)) continue;
            if (k - key == key) ans += Math.floor(map.get(key) / 2);
            else ans += Math.min(map.get(key), map.get(k - key));
            visited.add(key);
            visited.add(k - key);
        }
        
        return ans;
    }
}