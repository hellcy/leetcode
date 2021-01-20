class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int num = nums[i] * nums[j];
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        int ans = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                ans += (1 + (map.get(key) - 1)) * (map.get(key) - 1) / 2.0;
            }
        }
        
        ans *= 8;
        
        return ans;
    }
}