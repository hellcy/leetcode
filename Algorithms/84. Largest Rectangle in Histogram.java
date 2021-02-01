class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
            monotonic stack
        */
        int n = heights.length;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (stack1.isEmpty()) {
                stack1.add(heights[i]);
                stack2.add(i);
            } else {
                int prev = stack1.peek();
                if (heights[i] > prev) {
                    stack1.add(heights[i]);
                    stack2.add(i);
                } else {
                    int prevpos = stack2.peek();
                    while (!stack1.isEmpty() && stack1.peek() >= heights[i]) {
                        prev = stack1.pop();
                        prevpos = stack2.pop();
                        ans = Math.max(ans, (i - prevpos) * prev);
                    }
                    stack1.add(heights[i]);
                    stack2.add(prevpos);
                }
            }
        }

        while (!stack1.isEmpty()) {
            ans = Math.max(ans, stack1.pop() * (n - stack2.pop()));
        }

        return ans;
    }
}