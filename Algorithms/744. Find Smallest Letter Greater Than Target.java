class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        /*
            Binary Search
                the low and high pointers will finally point to the position meets the requirement
                the smallest element in the list that is larger than the given target
                Use the reminder if the element is the last element in the list
        */
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else if (letters[mid] > target) {
                high = mid - 1;
            }
        }
        
        return letters[low % letters.length];
    }
}