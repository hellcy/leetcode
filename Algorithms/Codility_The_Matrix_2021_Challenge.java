// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        /*
            monotonic stack
        */
        int n = A.length;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (stack1.isEmpty()) {
                stack1.add(A[i]);
                stack2.add(i);
            } else {
                int prev = stack1.peek();
                if (A[i] > prev) {
                    stack1.add(A[i]);
                    stack2.add(i);
                } else {
                    int prevpos = -1;
                    while (!stack1.isEmpty() && stack1.peek() >= A[i]) {
                        prev = stack1.pop();
                        prevpos = stack2.pop();
                        ans = Math.max(ans, Math.min(prev, i - prevpos));
                    }
                    stack1.add(A[i]);
                    stack2.add(prevpos);
                }
            }
        }

        while (!stack1.isEmpty()) {
            ans = Math.max(ans, Math.min(n - stack2.pop(), stack1.pop()));
        }

        return ans;
    }
}
