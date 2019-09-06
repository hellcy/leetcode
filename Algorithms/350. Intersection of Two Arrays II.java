class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*
            HashMap
                store nums1 and nums2 in two maps
                traverse a map
                if a key is found in both maps, add the smaller value times of it to the list
        */
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int j : map1.keySet()) {
            if (map2.containsKey(j)) {
                int n = Math.min(map2.get(j), map1.get(j));
                for (int i = 0; i < n; ++i) {
                    list.add(j);
                }
            }
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}