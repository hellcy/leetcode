class Solution {
    public void moveZeroes(int[] nums) {
        /*
            Algorithm explained:
                two pointers
                if neither of them are point to zero, move both of them to next
                if fast is pointing to zero, move to next, fast is trying to find next non-zero number
                then replace it with slow pointer's value
        */
        // int slow = 0;
        // int fast = 0;
        // int temp;
        // while (fast < nums.length) {
        //     if (nums[fast] == 0) {
        //         fast++;              
        //     } else if (nums[slow] == 0){
        //         temp = nums[fast];
        //         nums[fast] = nums[slow];
        //         nums[slow] = temp;
        //         slow++;
        //         fast++;
        //     } else {
        //         fast++;
        //         slow++;
        //     }
        // }

        
        /*
            Two pointers at same direction
        */
        int zero = 0, nonzero = 0;
        int length = nums.length;
        
        while (zero < length && nonzero < length) {
            while (nonzero < length && nums[nonzero] == 0) {
                nonzero++;
            }
            
            if (nonzero < length) {
                int temp = nums[nonzero];
                nums[nonzero] = nums[zero];
                nums[zero] = temp;
                zero++;
                nonzero++;
            }
        }
        
    }
}