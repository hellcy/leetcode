class Solution {
    public int countElements(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int max = Integer.MIN_VALUE;
//         int min = Integer.MAX_VALUE;
        
//         for (int i : nums) {
//             max = Math.max(max, i);
//             min = Math.min(min, i);
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }
        
//         int res = 0;
//         for (int key : map.keySet()) {
//             if (key != max && key != min) {
//                 res += map.get(key);
//             }
//         }
        
//         return res;
        
        // sorting
        Arrays.sort(nums);
        int count = 0;
        int min = nums[0];
        int max = nums[nums.length - 1];
        
        int index = 0;
        while (index < nums.length && nums[index] == min) {
            count++;
            index++;
        }
        
        index = nums.length - 1;
        while (index >= 0 && nums[index] == max) {
            count++;
            index--;
        }
        
        int res = (nums.length - count) > 0 ? (nums.length - count) : 0;
        
        return res;
    }
}