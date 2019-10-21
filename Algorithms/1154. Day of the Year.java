class Solution {
    public int dayOfYear(String date) {
        /*
            String
            String to int
            Leap year
                remember the definition of leap year
            Similar to question 1185 day of the week
        */
        String[] array = date.split("-");
        int[] montharray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.valueOf(array[0]);
        int month = Integer.valueOf(array[1]);
        int day = Integer.valueOf(array[2]);
        
        //System.out.println(year + " " + month + " " + day);
        int count = 0;
        for (int i = 0; i < month - 1; ++i) {
            count += montharray[i];
        }
        if (check(year) && month > 2) count++;
        count += day;
        return count;
    }
    
    private boolean check(int year) {
        if (year % 400 == 0) return true;
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else return false;
    }
}