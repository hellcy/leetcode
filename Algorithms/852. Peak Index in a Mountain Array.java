class Solution {
    public int peakIndexInMountainArray(int[] A) {
        /*
            Brute force
                the first half of the array is incresing, return index when array start decresing
        */
        // int ans = Integer.MIN_VALUE;
        // for (int i = 0; i < A.length; ++i) {
        //     if (ans < A[i]) {
        //         ans = A[i];
        //     } else {
        //         return i - 1;
        //     }
        // }
        // throw null;
        
        /*
            Binary Search
                create two pointer, one start from begining, another start from end
                each time we find the middle point, and compare the mid with mid + 1
                    if (mid < mid + 1), we know the peak number is on the upper side, range from (mid + 1, end)
                    if (mid > mid + 1), we know peak number is in range (start, mid)
                    keep finding untill low >= high, at this stage both low and high are pointing to the same number
                    which is the answer
        */
        int low = 0;
        int high = A.length - 1;
        
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high; // return low
    }
}