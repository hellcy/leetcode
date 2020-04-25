class Solution {
    public int findUnsortedSubarray(int[] nums) {
        /*
            Algorithm explained:
            1. brute force
            start from left, find minimum number for the rest array, if the current value is less than the min, go to next
                if not, we found the left starting point
            then start from right, find max number, if current value is greater than max, go to next
                if not, we found the right starting point
            return end - start + 1
        */
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        int pointer = 0;
        
        while (pointer < nums.length) {
            min = Integer.MAX_VALUE;
            for (int i = pointer + 1; i < nums.length; ++i) {
                if (nums[i] < min) {
                    min = nums[i];
                }
            }
            if (min >= nums[pointer]) {
                pointer++;
            } else {
                break;
            }
        }
        
        if (pointer == nums.length - 1) return nums.length;
        
        int start = pointer;
        
        pointer = nums.length - 1;
        
        while (pointer >= start) {
            max = Integer.MIN_VALUE;
            for (int i = pointer - 1; i >= 0; --i) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            if (max <= nums[pointer]) {
                pointer--;
            } else {
                break;
            }
        }
        
        int end = pointer;
        
        return end - start + 1;
        
        /*
            The idea behind this approach is also based on selective sorting. We need to determine the correct position of the minimum and the maximum element in the unsorted subarray to determine the boundaries of the required unsorted subarray.

            To do so, in this implementation, we make use of a stackstack. We traverse over the numsnums array starting from the beginning. As we go on facing elements in ascending order(a rising slope), we keep on pushing the elements' indices over the stackstack. This is done because such elements are in the correct sorted order(as it seems till now). As soon as we encounter a falling slope, i.e. an element nums[j]nums[j] which is smaller than the element on the top of the stackstack, we know that nums[j]nums[j] isn't at its correct position.

            In order to determine the correct position of nums[j]nums[j], we keep on popping the elemnents from the top of the stackstack until we reach the stage where the element(corresponding to the index) on the top of the stackstack is lesser than nums[j]nums[j]. Let's say the popping stops when the index on stackstack's top is kk. Now, nums[j]nums[j] has found its correct position. It needs to lie at an index k + 1k+1.

            We follow the same process while traversing over the whole array, and determine the value of minimum such kk. This marks the left boundary of the unsorted subarray.

            Similarly, to find the right boundary of the unsorted subarray, we traverse over the numsnums array backwards. This time we keep on pushing the elements if we see a falling slope. As soon as we find a rising slope, we trace forwards now and determine the larger element's correct position. We do so for the complete array and thus, determine the right boundary.

            We can look at the figure below for reference. We can observe that the slopes directly indicate the relative ordering. We can also observe that the point bb needs to lie just after index 0 marking the left boundary and the point aa needs to lie just before index 7 marking the right boundary of the unsorted subarray.
        */
        
//         Stack<Integer> stack = new Stack<>();
//         int left = nums.length, right = 0;
        
//         for (int i = 0; i < nums.length; ++i) {
//             while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
//                 left = Math.min(left, stack.pop());
//             }
//             stack.push(i);
//         }
        
//         stack.clear();
//         for (int i = nums.length - 1; i >= 0; --i) {
//             while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
//                 right = Math.max(right, stack.pop());
//             }
//             stack.push(i);
//         }
//         if (left > right) return 0;
//         return right - left + 1;
    }
}