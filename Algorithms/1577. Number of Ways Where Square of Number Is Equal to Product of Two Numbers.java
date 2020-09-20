class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> map1 = new HashMap<>();
        Map<Long, Integer> map2 = new HashMap<>();
        
        for (long i : nums1) {
            map1.put(i * i, map1.getOrDefault(i * i, 0) + 1);
        }
        
        for (long i : nums2) {
            map2.put(i * i, map2.getOrDefault(i * i, 0) + 1);
        }
        
        int count = 0;
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = i + 1; j < nums1.length; ++j) {
                long current = (long)nums1[i] * nums1[j];
                if (map2.containsKey(current)) {
                    count += map2.get(current);
                }
            }
        }
        
        for (int i = 0; i < nums2.length; ++i) {
            for (int j = i + 1; j < nums2.length; ++j) {
                long current = (long)nums2[i] * nums2[j];
                if (map1.containsKey(current)) {
                    count += map1.get(current);
                }
            }
        }
        
        return count;
    }
}