class Solution {
    public int maxArea(int[] height) {
        /*
            Algorithm explained:
                Initially we consider the area constituting the exterior most lines. 
                Now, to maximize the area, we need to consider the area between the lines of larger lengths. 
                If we try to move the pointer at the longer line inwards, we won't gain any increase in area, 
                since it is limited by the shorter line. 
                But moving the shorter line's pointer could turn out to be beneficial, as per the same argument, 
                despite the reduction in the width. 
                This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.
        */
        int area = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            area = Math.max(area, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) start++;
            else end--;
        }
        return area;
    }
}