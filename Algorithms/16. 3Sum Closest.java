class Solution {
    /*
        BackTracking
    */
    int ans = Integer.MAX_VALUE / 2, tar = 0;
    public int threeSumClosest(int[] nums, int target) {
        tar = target;
        helper(nums, 0, 0, 0);
        return ans;
    }
    
    private void helper(int[] nums, int sum, int start, int number) {
        if (number == 3) {
            //long var = Math.abs(ans - tar);
            //System.out.println(var + " " + Math.abs(sum - tar));
            if (Math.abs(ans - tar) >= Math.abs(sum - tar)) {
                //System.out.println(var + " " + Math.abs(sum - tar));
                ans = sum;
            }
        }
        else {
            for (int i = start; i < nums.length; ++i) {
                helper(nums, sum + nums[i], i + 1, number + 1);
            }
        }
    }
}

class Solution {
    int diff = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    public int threeSumClosest(int[] nums, int target) {
        /*
            Two pointers
        */
        
        int length = nums.length;
        
        Arrays.sort(nums);

        for (int i = 0; i < length; ++i) {
            int value = target - nums[i];
            int left = i + 1, right = length - 1;
            ans = twosum(nums, value, left, right, target);
        }
        
        return ans;
    }
    
    private int twosum(int[] nums, int value, int left, int right, int target) {
        while (left < right) {
            //System.out.println(diff);
            if (nums[left] + nums[right] == value) {
                diff = 0;
                return nums[left] + nums[right] - value + target;
            } else if (nums[left] + nums[right] < value) {
                if (value - (nums[left] + nums[right]) < diff) {
                    diff = value - (nums[left] + nums[right]);
                    ans = nums[left] + nums[right] - value + target;
                }
                left++;
            } else {
                if ((nums[left] + nums[right]) - value < diff) {
                    diff = (nums[left] + nums[right]) - value;
                    ans = nums[left] + nums[right] - value + target;
                }
                right--;
            }
        }
        
        return ans;
    }
}