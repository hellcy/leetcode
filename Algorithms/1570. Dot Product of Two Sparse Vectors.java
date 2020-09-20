class SparseVector {
    Map<Integer, Integer> map;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int cur = nums[i];
            if (cur != 0) {
                map.put(i, cur);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Map<Integer, Integer> map2 = vec.map;
        int ans = 0;
        for (int key : map2.keySet()) {
            if (map.containsKey(key)) {
                ans += map2.get(key) * map.get(key);
            }
        }
        
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);