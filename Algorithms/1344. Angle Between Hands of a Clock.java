class Solution {
    /*
        set 12:00 as the starting point, 
        hour hand passes (minutes / 60.0 * 30 + hour * 30) degrees
        minutes hand passes (6 * minutes) degrees
        calculate its smaller absolute value
    */
    public double angleClock(int hour, int minutes) {
        double ans = 0;
        if (hour == 12) {
            ans = Math.abs(6 * minutes - (minutes / 60.0 * 30));
        } else {
            ans = Math.abs(6 * minutes - (minutes / 60.0 * 30 + hour * 30));
        }
        
        if (ans > 180) ans = 360 - ans;
        return ans;
    }
}