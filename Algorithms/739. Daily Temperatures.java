class Solution {
    public int[] dailyTemperatures(int[] T) {
        /*
            Monotone Stack
            Intuition

Consider trying to find the next warmer occurrence at T[i]. What information (about T[j] for j > i) must we remember?

Say we are trying to find T[0]. If we remembered T[10] = 50, knowing T[20] = 50 wouldn't help us, as any T[i] that has its next warmer ocurrence at T[20] would have it at T[10] instead. However, T[20] = 100 would help us, since if T[0] were 80, then T[20] might be its next warmest occurrence, while T[10] couldn't.

Thus, we should remember a list of indices representing a strictly increasing list of temperatures. For example, [10, 20, 30] corresponding to temperatures [50, 80, 100]. When we get a new temperature like T[i] = 90, we will have [5, 30] as our list of indices (corresponding to temperatures [90, 100]). The most basic structure that will satisfy our requirements is a stack, where the top of the stack is the first value in the list, and so on.

Algorithm

As in Approach #1, process indices i in descending order. We'll keep a stack of indices such that T[stack[-1]] < T[stack[-2]] < ..., where stack[-1] is the top of the stack, stack[-2] is second from the top, and so on; and where stack[-1] > stack[-2] > ...; and we will maintain this invariant as we process each temperature.

After, it is easy to know the next occurrence of a warmer temperature: it's simply the top index in the stack.

Here is a worked example of the contents of the stack as we work through T = [73, 74, 75, 71, 69, 72, 76, 73] in reverse order, at the end of the loop (after we add T[i]). For clarity, stack only contains indices i, but we will write the value of T[i] beside it in brackets, such as 0 (73).

When i = 7, stack = [7 (73)]. ans[i] = 0.
When i = 6, stack = [6 (76)]. ans[i] = 0.
When i = 5, stack = [5 (72), 6 (76)]. ans[i] = 1.
When i = 4, stack = [4 (69), 5 (72), 6 (76)]. ans[i] = 1.
When i = 3, stack = [3 (71), 5 (72), 6 (76)]. ans[i] = 2.
When i = 2, stack = [2 (75), 6 (76)]. ans[i] = 4.
When i = 1, stack = [1 (74), 2 (75), 6 (76)]. ans[i] = 1.
When i = 0, stack = [0 (73), 1 (74), 2 (75), 6 (76)]. ans[i] = 1.

        */
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        
        return ans;
        
        /*
            Two pointers
              use fast pointer to find the next warmer day, add count to list
              then slow++, and assign fast back to slow to start next round
        */
//         int fast = 0;
//         int slow = 0;
//         int count = 0;
        
//         int[] ans = new int[T.length];
//         while (fast <= T.length && slow < T.length) {
//             if (fast == T.length) {
//                 ans[slow] = 0;
//                 slow++;
//                 fast = slow;
//                 count = 0;
//             }
//             else if (T[fast] <= T[slow]) {
//                 fast++;
//                 count++;
//             } else {
//                 ans[slow] = count;
//                 count = 0;
//                 slow++;
//                 fast = slow;
//             }
//         }
        
//         return ans;
    }
}