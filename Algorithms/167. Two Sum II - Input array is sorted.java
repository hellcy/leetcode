class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
            Two Sum
            Two pointers
        */
        int left = 0, right = numbers.length - 1;
        
        while (left <= right) {
            while (right >= left && numbers[left] + numbers[right] > target) {
                right--;
            }
            
            while (right >= left && numbers[left] + numbers[right] < target) {
                left++;
            }
            
            if (numbers[left] + numbers[right] == target) {
                return new int[] {left + 1, right + 1};
            }
        }
        
        return new int[] {-1, -1};
    }
}