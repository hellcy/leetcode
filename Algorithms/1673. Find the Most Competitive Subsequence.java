class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        /*
            Stack
            for each new number, 
            1. if we can lose any number to get subsequence of size k, add it to stack
            2. if we can, check stack, pop number until the top of stack < new number, add it to stack
            stack will be increase e.g. [2,3,3,4,6]
            get the first k numbers from stack
        */

        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (stack.isEmpty() || (nums[i] >= stack.peek())) {
                stack.add(nums[i]);
            } else {
                if (n - i + stack.size() <= k) stack.add(nums[i]);
                else {
                    while (!stack.isEmpty() && nums[i] < stack.peek() && (n - i + stack.size() > k)) {
                        //System.out.println(stack.peek() + " " + nums[i]);
                        stack.pop();
                    }
                    stack.add(nums[i]);
                }
            }
        }
        while(stack.size() > k) 
        {
            stack.pop();
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}