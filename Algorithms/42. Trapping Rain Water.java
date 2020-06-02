class Solution {
    public int trap(int[] height) {
        /*
            two pointers
            1. start at left and right side
            2. the water can only be higher than min(left bar, right bar)
            3. keep moving bars towards the center, update bar's value if it is higher.
        */
        int water = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > height[left + 1]) {
                    water += height[left] - height[left + 1];
                    height[left + 1] = height[left];
                }
                left++;
            } else {
                if (height[right] > height[right - 1]) {
                    water += height[right] - height[right - 1];
                    height[right - 1] = height[right];
                }
                right--;
            }
        }
        
        return water;
    }
}