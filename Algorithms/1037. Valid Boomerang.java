class Solution {
    public boolean isBoomerang(int[][] points) {
        /*
            Math
                compare the slopes of two lines
        */
        double slope1 = 0, slope2 = 0;
        boolean reverse = false;
        int x = points[1][0] - points[0][0];
        int y = points[1][1] - points[0][1];
        if (x == 0 && y == 0) return false;

        if (y == 0){
            y = x;
            x = 0;
            reverse = true;
        }

        slope1 = x / (double)y;
        
        x = points[2][0] - points[1][0];
        y = points[2][1] - points[1][1];
        //System.out.println(x + " " + y + " " + reverse);

        if (x == 0 && y == 0) return false;

        if (y == 0 && reverse == true) return false;
        else if (y == 0 && reverse == false) return true;
        
        if (x == 0 && reverse == true) return true;
        
        slope2 = x / (double)y;
        //System.out.println(slope1 + " " + slope2);
        if (Math.abs(slope1 - slope2) < 0.000001) return false;
        else return true;
    }
}