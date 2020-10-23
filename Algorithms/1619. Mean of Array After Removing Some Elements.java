class Solution {
    public double trimMean(int[] arr) {
        double ans = 0.0;
        int n = arr.length;
        int left = (int)(n * 0.05);
        int right = (int)(n * 0.95);
        //System.out.println(left + " " + right);
        int total = 0;
        Arrays.sort(arr);
        for (int i = left; i < right; ++i) {
            total += arr[i];
        }
        
        return total * 1.0 / (right - left);
    }
}