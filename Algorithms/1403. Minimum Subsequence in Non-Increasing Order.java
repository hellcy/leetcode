class Solution {
    /*
        1. sort the array
        2. calculate the sum of the entire array
        3. keep adding number from the largest to the list until sum of list is greater than the sum of the rest of the array
    */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        List<Integer> list = new ArrayList<>();
        int listsum = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (listsum <= sum - listsum) {
                list.add(nums[i]);
                listsum += nums[i];
            } else {
                break;
            }
        }
        return list;
    }
}