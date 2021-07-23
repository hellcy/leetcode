class Solution {
    public boolean canBeIncreasing(int[] nums) {
        // Stack
        boolean forwardCheck = checkArray(nums, true);
        
        for (int i = 0; i < nums.length / 2; ++i) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        
        boolean backwardCheck = checkArray(nums, false);
        
        return forwardCheck || backwardCheck;
    }
    
    private boolean checkArray(int[] nums, boolean isForward) {
        Stack<Integer> stack = new Stack<>();
        boolean found = false;
        
        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.add(num);
            } else if (isForward) {
                if (num > stack.peek()) {
                    stack.add(num);
                } else {
                    if (!found) found = true;
                    else return false;
                }
            } else if (!isForward) {
                  if (num < stack.peek()) {
                    stack.add(num);
                } else {
                    if (!found) found = true;
                    else return false;
                }
            }
        }
        return true;
    }
}