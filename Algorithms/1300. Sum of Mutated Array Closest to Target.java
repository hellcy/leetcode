class Solution {
    public int findBestValue(int[] arr, int target) {
        /*
            Binary Search
                calcualte the sum after given a value
                binary search to find the value
        */
        Arrays.sort(arr);
        int start = 0, end = arr[arr.length - 1];
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            int sum = helper(arr, mid);
            if (sum == target) {
                return mid;
            } else if (sum > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        //System.out.println(start + " " + end);
        //System.out.println(helper(arr, end));
        if (Math.abs(helper(arr, start) - target) > Math.abs(helper(arr, end) - target)) return end;
        else return start;
    }
    
    private int helper(int[] arr, int value) {
        int sum = 0;
        int pos = 0;
        //System.out.println(value);
        while (pos < arr.length && arr[pos] <= value) {
            sum += arr[pos];
            pos++;
        }
        sum += (arr.length - pos) * value;
        return sum;
    }
}