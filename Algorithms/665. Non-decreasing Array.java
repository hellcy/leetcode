class Solution {
    public boolean checkPossibility(int[] nums) {
        /*
            Algorithm explained:
                check the number of decreasing point
                    if greater than 1, return false;
                    else if the index of that decresing point is start or end, return true
                    else look at the shape, if modify the decresing point or the previous point would make the list non-decresing, return true
                    else return false
        */
        int index = -1;
        int count = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                index = i;
                count++;
            }
        }
        
        if (count <= 1) {
            if (index == -1 || index == 1 || index == nums.length - 1) return true;
            else if (nums[index - 1] >= nums[index + 1] && nums[index] > nums[index - 2]) return true;
            else if (nums[index - 1] < nums[index + 1]) return true;
            else return false;
        } else {
            return false;
        }
    }
}