class Solution {
    public int maxNumberOfApples(int[] arr) {
        /*
            Sort array
                sort the array and take the apple with the smallest weight each time
        */
        Arrays.sort(arr);
        
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if (sum <= 5000) count++;
            else break;
        }
        
        return count;
    }
}