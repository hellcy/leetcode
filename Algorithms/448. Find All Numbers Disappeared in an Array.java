class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*
            algorithm explained:
                create a new array with size + 1
                move values to its correct place in the new array
                add index with value zero to the list
        */
//         int[] array = new int[nums.length];
//         List<Integer> list = new ArrayList<>();        
        
//         for (int i = 0; i < nums.length; ++i) {
//             array[nums[i] - 1] = nums[i];
//         }
        
//         for (int i = 0; i <array.length; ++i) {
//             if (array[i] == 0) {
//                 list.add(i + 1);
//             }
//         }
//         return list;
        /*
            O(n) time with no extra space
            all numbers >= 1 and from [1, n] where n is the size of array
            we mark the visited numbers as negative
        */
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[Math.abs(nums[i]) - 1] > 0) nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        
        return list;
    }
}