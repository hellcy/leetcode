class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
            Merge sort
                merge two sorted arrays into one sorted array
                then find the median of that array
        */
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] array = new int[n1 + n2];
        for (int i = 0; i < n1; ++i) {
            array[i] = nums1[i];
        }
        for (int i = 0; i < n2; ++i) {
            array[n1 + i] = nums2[i];
        }
        
        int start = 0;
        int end = array.length - 1;
        int mid = n1 - 1;
        
        int p = 0, q = mid + 1, k = 0;
        int[] ans = new int[end - start + 1];
        
        while (k < ans.length) {
            if (p > mid) ans[k++] = array[q++];
            else if (q > end) ans[k++] = array[p++];
            else if (array[p] < array[q]) ans[k++] = array[p++];
            else ans[k++] = array[q++];
        }
        
        for (int i = 0; i < k; ++i) {
            //System.out.println(ans[i]);
            array[start++] = ans[i];
        }
        int n = array.length;
        double median = 0;
        if (n % 2 == 0){
            median = (array[n / 2] + array[(n / 2) - 1]) / (double)2;
        } else {
            median = array[n / 2];
        }
        return median;
    }
}