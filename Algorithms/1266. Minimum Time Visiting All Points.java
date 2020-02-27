class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        /*
            Array
            Geometry
        */
        int total = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            int x = Math.abs(points[i][0] - points[i + 1][0]);
            int y = Math.abs(points[i][1] - points[i + 1][1]);
            total += time(x, y);
        }
        
        return total;
    }
    
    private int time(int x, int y) {
        int sec = 0;
        //System.out.println(x + " " + y);
        while (x > 0 && y > 0) {
            sec++;
            x--;
            y--;
        }
        
        sec += Math.max(x, y);
        return sec;
    }
}