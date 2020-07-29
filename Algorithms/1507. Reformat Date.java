class Solution {
    public String reformatDate(String date) {
        String[] days = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th", "20th", "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st"};
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        String[] input = date.split(" ");
        String day = input[0];
        String month = input[1];
        String year = input[2];
        
        int day2 = -1;
        int month2 = -1;
        int year2 = -1;
        
        for (int i = 0; i < days.length; ++i) {
            if (day.equals(days[i])) {
                day2 = i + 1;
            }
        }
        
        for (int i = 0; i < months.length; ++i) {
            if (month.equals(months[i])) {
                month2 = i + 1;
            }
        }
        System.out.println(day2);
        String month3 = "";
        if (month2 < 10) month3 = "0" + String.valueOf(month2);
        else month3 = String.valueOf(month2);
        
        String day3 = "";
        if (day2 < 10) day3 = "0" + String.valueOf(day2);
        else day3 = String.valueOf(day2);
        
        year2 = Integer.valueOf(year);
        return year + "-" + month3 + "-" + day3;
    }
}