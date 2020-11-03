class Solution {
    public int maxDistToClosest(int[] seats) {
        int count = 0;
        int start = 0, end = 0;
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                start = i;
                break;
            }
        }
        
        for (int i = seats.length - 1; i >= 0; --i) {
            if (seats[i] == 1) {
                end = i;
                break;
            }
        }
        
        int max = 0;
        for (int i = start; i <= end; ++i) {
            if (seats[i] == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        if (max % 2 == 0) max /= 2;
        else max = max / 2 + 1;
        
        //System.out.println(start + " " + end + " " + max);
        return Math.max(max, Math.max(start, seats.length - end - 1));
    }
}