class Solution {
    public int countPairs(int[] deliciousness) {
        /*
            Similar to Two Sum
            Don't add numbers to Map first
            Add numbers while iterating the array to eliminate duplicates
            
            Also be careful about the boundaries, deliciousness[i] is bound to 0 to 2^20
            So we need to check power of two range from 1 to 2^21, 1 is also a power of two
        */
        int mod = (int)10e8 + 7;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer> nums = new HashSet<>();
        int cur = 1;
        for (int i = 0; i <= 21; ++i) {
            nums.add(cur);
            cur = cur * 2;
        }
        
        for (int i : deliciousness) {
            for (int j : nums) {
                if (map.containsKey(j - i)) {
                    ans += map.get(j - i);
                    ans %= mod;
                }
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        return ans;
    }
}