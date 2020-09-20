class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        /*
            Time O(n)
            Space O(n)
        */
        // Set<Integer> set = new HashSet<>();
        // List<Integer> list = new ArrayList<>();
        // for (int i : nums) {
        //     if (set.contains(i)) {
        //         list.add(i);
        //     } else set.add(i);
        // }
        // return list;
        
        /*
            The integers in the input array arr satisfy 1 ≤ arr[i] ≤ n, where n is the size of array
            This presents us with two key insights:
            All the integers present in the array are positive. i.e. arr[i] > 0 for any valid index i.
            The decrement of any integers present in the array must be an accessible index in the array.
            i.e. for any integer x in the array, x-1 is a valid index, and thus, arr[x-1] is a valid reference to an element in the array
        */
        
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) { // seen before
                ans.add(Math.abs(num));
            }
            nums[Math.abs(num) - 1] *= -1;
        }

        return ans;
    }
}