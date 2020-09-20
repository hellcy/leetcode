class Solution {
    public int getMaxLen(int[] nums) {
        /*
            1. if number is zero, we reset everything
            2. keep track of the number of negative numbers since last zero
            3. also keep track of the first negative number since last zero
            4. max should be current index - last zero when (number of neagtives are even)
            5. max should be current index - last negative when (number of negatives are odd)(exclude the first negative number)
        */
        int firstnegative = -1, zeroposition = -1;
        int negativenum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) {
                negativenum++;
                if (firstnegative == -1) firstnegative = i;
            }
            
            if (nums[i] == 0) {
                zeroposition = i;
                firstnegative = -1;
                negativenum = 0;
            } else {
                if (negativenum % 2 == 0) max = Math.max(max, i - zeroposition);
                else max = Math.max(max, i - firstnegative);
            }
        }
        return max;
    }
}