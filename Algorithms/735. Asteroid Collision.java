class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        /*
            Stack
        */
        Stack<Integer> stack = new Stack<>();
        stack.add(asteroids[0]);
        int n = asteroids.length;
        for (int i = 1; i < n; ++i) {
            int num = asteroids[i];
            boolean ok = false;
            
            while (stack.size() > 0 && stack.peek() > 0 && num < 0) {
                int prev = stack.pop();
                if (Math.abs(prev) >= Math.abs(num)) {
                    if (Math.abs(prev) > Math.abs(num)) stack.add(prev);
                    ok = true;
                    break;
                }
            }
            
            if (!ok) stack.add(num);
        }
        
        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; --i) {
            ans[i] = stack.pop();
        }
        
        return ans;
    }
}