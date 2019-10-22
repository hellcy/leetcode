class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        /*
            Algorithm explained:
                create a array
                for each value in arr2, if we found it in arr1, add it to the array
                for those who doesn't appear in arr2, add it to the end
                assign values back to arr1 from array
                merge sort arr1, index start from the values don't appear in arr2
        */
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr2.length; ++i) {
            set.add(arr2[i]);
            for (int j = 0; j < arr1.length; ++j) {
                if (arr1[j] == arr2[i]) {
                    list.add(arr1[j]);
                    count++;
                }
            }
        }
        //System.out.println(count);
        
        int[] array = new int[arr1.length];
        for (int i = 0; i < arr1.length; ++i) {
            if (!set.contains(arr1[i])) {
                list.add(arr1[i]);
            }
        }
        
        for (int i = 0; i < arr1.length; ++i) {
            arr1[i] = list.get(i);
        }
        
        int start = count;
        int end = arr1.length - 1;
        merge_sort(arr1, start, end);
        
        return arr1;
    }
    
    private void merge_sort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(nums, start, mid);
            merge_sort(nums, mid + 1, end);
            
            merge(nums, start, mid, end);
        }
    }
    
    private void merge(int[] nums, int start, int mid, int end) {
        int p = start, q = mid + 1, k = 0;
        int[] array = new int[end - start + 1];
        
        for (int i = 0; i < array.length; ++i) {
            if (p > mid) array[k++] = nums[q++];
            else if(q > end) array[k++] = nums[p++];
            else if (nums[p] < nums[q]) array[k++] = nums[p++];
            else array[k++] = nums[q++];
        }
        
        for (int i = 0; i < array.length; ++i) {
            nums[start++] = array[i];
        }
        
    }
}