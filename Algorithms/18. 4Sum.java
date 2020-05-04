class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*
            Similar to 3sum, 3sum closest and 2sum
            1. 2 for loops go through two number, and use 2sum template to find a quadruplets
            2. skip duplicate numbers for each loop
        */
        List<List<Integer>> lists = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; ++j) {
                int value = target - (nums[i] + nums[j]);
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                twosumhelper(nums, lists, j + 1, value, nums[i], nums[j]);
            }
        }
        return lists;
    }
    
    private void twosumhelper(int[] nums, List<List<Integer>> lists, int start, int value, int one, int two) {
        int left = start, right = nums.length - 1;
        //System.out.println(value + " " + start + " " + nums[right]);
        while (left < right) {
            if (nums[left] + nums[right] == value) {
                List<Integer> list = new ArrayList<>();
                
                list.add(one);
                list.add(two);
                list.add(nums[left]);
                list.add(nums[right]);
                lists.add(list);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
            else if (nums[left] + nums[right] < value) {
                left++;
            } else {
                right--;
            }
        }
    }
}