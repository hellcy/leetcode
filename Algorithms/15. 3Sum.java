class Solution {
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        /*
            a + b + c = 0;
            b + c = -a
            Same as find a pair of numbers sum equals to minus the third number
        */

        /*
            Algorithm explained:
                for each value in array, try to find two other values that add to minus that value
                using two sum as an assist
                pass the index + 1 so we don't reuse values
                sort the list so we don't add duplicate triplets
        */
        List<List<Integer>> lists = new ArrayList<>();
        if (numbers == null || numbers.length == 0) return lists;
        
        int length = numbers.length;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(numbers);
        for (int i = 0; i < length; ++i) {
            // skip duplicates
            if (i > 0 && numbers[i] == numbers[i - 1]) continue;
            
            int left = i + 1, right = length - 1;
            
            twosumTwoPointers(lists, numbers, left, right, -numbers[i]);
        }
        
        return lists;
    }
    
    
    /*
        Two pointers
        Array must be sorted first!!!
    */
    private void twosumTwoPointers(List<List<Integer>> lists, int[] nums, int left, int right, int target) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                list.add(-target);
                lists.add(list);
                left++;
                right--;
                
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
    }
    
    
    /*
        HashMap
    */
    private void twosumHashMap(List<List<Integer>> lists, int[] nums, int left, int right, int target, Set<List<Integer>> set) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = left; i <= right; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int i : map.keySet()) {
            if (map.containsKey(target  - i)) {
                if (i != target - i || map.get(i) > 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(target - i);
                    list.add(-target);
                    Collections.sort(list);
                    if (!set.contains(list)) lists.add(list);
                    set.add(list);
                }
            }
        }
    }
}