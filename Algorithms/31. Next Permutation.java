class Solution {
    public void nextPermutation(int[] nums) {
        /*
            from right to left
            find first occurance where nums[i] < nums[i + 1]
            replace nums[i] with the minimum number that is greater than it from nums[i + 1] to end
            then sort the subarray nums[i + 1]...end
        */
        
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1) {
                list.add(nums[i]);
                continue;
            }
            if (nums[i] < nums[i + 1]) {
                Collections.sort(list);
                for (int j = 0; j < list.size(); ++j) {
                    if (list.get(j) > nums[i]) {
                        int temp = nums[i];
                        nums[i] = list.get(j);
                        list.set(j, temp);
                        index = i;
                        break;
                    }
                }
                break;
            } else {
                list.add(nums[i]);
            }
        }
        
        

        Collections.sort(list);
        // if list.size() == n, the arr is decresing already, sort it start with 0, so let index = -1
        if (list.size() == n) index = -1;
        for (int i = index + 1; i < n; ++i) {
            nums[i] = list.get(i - index - 1);
        }

        
    }
}