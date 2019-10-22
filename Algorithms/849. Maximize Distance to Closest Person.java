class Solution {
    public int maxDistToClosest(int[] seats) {
        /*
            Algorithm explained:
                count the starting zeros and ending zeros, those are special cases
                if the max zeros are in the middle, divide it by 2
                find the max among these three numbers
        */
        int count = 0;
        int countStart = 0;
        int countEnd = 0;
        int max = 0;
        
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 0) {
                countStart++;
            } else {
                break;
            }
        }   
        
        for (int i = seats.length - 1; i >= 0; --i) {
            if (seats[i] == 0) {
                countEnd++;
            } else {
                break;
            }
        }
        
        //System.out.println(countStart + " " + countEnd);
        
        for (int i = 0; i < seats.length - 1; ++i) {
            if (seats[i] == 0 && seats[i + 1] == 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        
        max = (max + 2) / 2;
        
        max = Math.max(max, Math.max(countStart, countEnd));
        return max;
    }
}