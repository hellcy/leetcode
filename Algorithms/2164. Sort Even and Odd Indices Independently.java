class Solution {
    public int[] sortEvenOdd(int[] nums) {
        // create two arrays to store odd indices and even indices numbers
        // sort the arrays and merge them back together
        
        int length = nums.length;
        boolean isEven = length % 2 == 0;
        
        int[] oddArray = new int[length / 2];
        int[] evenArray = new int[length / 2 + (isEven ? 0 : 1)];
        
        for (int i = 0; i < length; ++i) {
            if (i % 2 != 0) {
                oddArray[i / 2] = nums[i];
            } else {
                evenArray[i / 2] = nums[i];
            }
        }
        
        // sort ascending and then reverse the array
        Arrays.sort(oddArray);
        for (int i = 0; i < oddArray.length / 2; ++i) {
            int temp = oddArray[i];
            oddArray[i] = oddArray[oddArray.length - 1 - i];
            oddArray[oddArray.length - 1 - i] = temp;
        }
        
        Arrays.sort(evenArray);
        
        
        int[] ans = new int[length];
        for (int i = 0; i < length; ++i) {
            if (i % 2 == 0) {
                ans[i] = evenArray[i / 2];
            } else {
                ans[i] = oddArray[i / 2];
            }
        }
        
        return ans;
        
    }
}