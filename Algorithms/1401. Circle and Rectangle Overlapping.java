class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        /*
            check rectangle, if the closest point on the rectangle to the center of the circle are greater than the radius, 
            no overlaps, otherwise overlaps
        */
        int closestx = 0, closesty = 0;
        
        if (x_center >= x2) {
            closestx = x2;
        } else if (x_center >= x1 && x_center < x2) {
            closestx = x_center;
        } else if (x_center < x1) {
            closestx = x1;
        }
        
        if (y_center >= y2) {
            closesty = y2;
        } else if (y_center >= y1 && y_center < y2) {
            closesty = y_center;
        } else if (y_center < y1) {
            closesty = y1;
        }
        
        int dx = Math.abs(x_center - closestx);
        int dy = Math.abs(y_center - closesty);
        int sqdistance = dx * dx + dy * dy;
        if (sqdistance <= radius * radius) return true;
        else return false;
    }
}