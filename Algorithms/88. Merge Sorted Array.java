class Solution {
    /*
        Merge sort
        Merge small array into big array
        Start from the end of array
        O(1) space
    */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        
        int index = nums1.length - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] < nums2[index2]) {
                nums1[index--] = nums2[index2--];
            } else {
                nums1[index--] = nums1[index1--];
            }
        }
        
        while (index1 >= 0) {
            nums1[index--] = nums1[index1--];
        }
        
        while (index2 >= 0) {
            nums1[index--] = nums2[index2--];
        }
        
    }
}