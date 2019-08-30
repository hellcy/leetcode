class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
            Algorithm explained:
                brute force
                check every pair of duplicates in the array and return true if their absolute distance is equal or smaller than k
        */
        // for (int i = 0; i < nums.length; ++i) {
        //     for (int j = 1 + i; j < nums.length; ++j) {
        //         if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
        //             //System.out.println(i + " " + j);
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
        /*
            Algorithm explained:
                hash map
                if map contains key, calculate the absolute distance and compare it with k
                Note: we don't need to track the max distance, just need to compare
                return if distance equal or smaller than k
        */
        HashMap<Integer, Integer> map = new  HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                //System.out.println(i + " " + map.get(nums[i]));
                map.put(nums[i], Math.abs(i - map.get(nums[i])));
                if (map.get(nums[i]) <= k) return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}