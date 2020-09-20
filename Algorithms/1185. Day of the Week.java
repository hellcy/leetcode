class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        /*
            1971 Jan 1 is Friday
        */
        
        String[] arr = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int days = 0;
        for (int i = 1971; i < year; ++i) {
            if (isLeap(i)) days += 366;
            else days += 365;
        }
        
        for (int i = 1; i < month; ++i) {
            if (isLeap(year) && i == 2) days += 29;
            else {
                days += months[i];
            }
        }
        
        days += day - 1;
        
        return arr[days % 7];
    }
    
    private boolean isLeap(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) return true;
        else return false;
    }
}