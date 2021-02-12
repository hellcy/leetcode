class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double ans = 0.0;
        int start = 0;
        for (int[] customer : customers) {
            start = start > customer[0] ? start : customer[0];
            ans += start + customer[1] - customer[0];
            start += customer[1];
        }
        return ans / n;
    }
}