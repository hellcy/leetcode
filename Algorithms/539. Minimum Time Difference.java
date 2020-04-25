class Solution {
    public int findMinDifference(List<String> timePoints) {
        /*
            String
            Brute force
                convert string to int and compare each pair of ints in the array
                if the distance between two integer values is greater than half of the whole day, which is 720 minutes
                we use the 1440 substract it to get the smaller value
        */
        int min = Integer.MAX_VALUE;
        
        int[] array = new int[timePoints.size()];
        
        for (int i = 0; i < timePoints.size(); ++i) {
            array[i] = convert(timePoints.get(i));
        }
        
        for (int i = 0; i < array.length; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                //System.out.println(array[i] + " " + array[j]);
                int distance = Math.abs(array[i] - array[j]);
                if (distance > 720) {
                    min = Math.min(min, 1440 - distance);
                } else {
                    min = Math.min(min, distance);
                }
            }
        }
        return min;
    }
    
    private int convert(String str) {
        int hour = Integer.valueOf(str.substring(0, 2));
        int minute = Integer.valueOf(str.substring(3, 5));
        int mins = hour * 60 + minute;
        
        return mins;
    }
}