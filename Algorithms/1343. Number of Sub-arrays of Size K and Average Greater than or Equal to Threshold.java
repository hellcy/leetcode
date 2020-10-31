class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int total = 0;
        for (int i = 0; i < k; ++i) {
            total += arr[i];
        }
        double average = 1.0 * total / k;
        if (average >= threshold) count++;

        for (int i = 1; i <= arr.length - k; ++i) {
            total += arr[i + k - 1];
            total -= arr[i - 1];
            
            average = total / k;
            if (average >= threshold) count++;
            //System.out.println(arr[i] + " " + i + " " + total + " " + average + " " + count);
        }
        
        return count;
    }
}