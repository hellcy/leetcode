class Solution {
    public int arrayPairSum(int[] nums) {
        /*
           Algorithm explained:
            sort the array
            for every pair of nums, add the first one to the result
        */
        // insertion sort
        // int temp;
        // for (int i = 1; i < nums.length; ++i) {
        //     for (int j = i; j > 0; --j) {
        //         if (nums[j] < nums[j - 1]) {
        //             temp = nums[j];
        //             nums[j] = nums[j - 1];
        //             nums[j - 1] = temp;
        //         }
        //     }
        // }
        
        // merge sort
        int start = 0;
        int end = nums.length - 1;
        merge_sort(nums, start, end);
        
        int result = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            result += nums[i];
        }
        return result;
    }
    
    private void merge_sort(int A[], int start, int end)
    {
        if(start < end) {
            int mid = (start + end) / 2; // defines the current array in 2 parts .
            merge_sort(A, start, mid); // sort the 1st part of array .
            merge_sort(A, mid + 1, end); // sort the 2nd part of array.

            // merge the both parts by comparing elements of both the parts.
            merge(A, start, mid, end);
        }
    }
    
    private void merge(int A[], int start, int mid, int end) {
        //stores the starting position of both parts in temporary variables.
        int p = start ,q = mid+1;
        int[] Arr = new int[end-start+1];
        int k = 0;

        for(int i = start ;i <= end ;i++) {
            if(p > mid) Arr[ k++ ] = A[ q++]; //checks if first part comes to an end or not .
            else if (q > end) Arr[ k++ ] = A[ p++ ]; //checks if second part comes to an end or not
            else if(A[p] < A[q]) Arr[ k++ ] = A[ p++ ]; //checks which part has smaller element.
            else Arr[k++] = A[q++];
        }
        
        for (p = 0; p < k; p++) {
            A[start++] = Arr[p]; // now copy the sorted array to original array                      
        }
    }
}