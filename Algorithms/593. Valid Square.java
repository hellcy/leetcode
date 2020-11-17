class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        /*
            four lines are equal
            and one angle between two lines is 90 degrees (lines are perpendicular)
        */
        double l1 = getlength(p1, p2);
        double l2 = getlength(p1, p3);
        double l3 = getlength(p1, p4);
        if (compare(l1, l2)) {
        	if (perpendicular(p1, p2, p1, p3)) {
        		double l4 = getlength(p4, p2);
        		double l5 = getlength(p4, p3);
        		return compare(l1, l4) && compare(l4, l5);
        	}
        } 
        if (compare(l1, l3)) {
        	if (perpendicular(p1, p2, p1, p4)) {
        		double l4 = getlength(p3, p2);
        		double l5 = getlength(p3, p4);
        		return compare(l1, l4) && compare(l4, l5);
        	}
        } 
        if (compare(l2, l3)) {
        	if (perpendicular(p1, p3, p1, p4)) {
        		double l4 = getlength(p2, p3);
        		double l5 = getlength(p2, p4);
        		return compare(l2, l4) && compare(l4, l5);
        	}
        } 
        return false;
    }
    
    private double getlength(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(Math.abs(p1[0] - p2[0]), 2) + Math.pow(Math.abs(p1[1] - p2[1]), 2));
    }

    private boolean compare(double a, double b) {
    	return Math.abs(a - b) < 0.00001;
    }

    private boolean perpendicular(int[] p1, int[] p2, int[] p3, int[] p4) {
    	double angle1 = Math.atan2(p1[1] - p2[1], p1[0] - p2[0]);
		double angle2 = Math.atan2(p3[1] - p4[1], p3[0] - p4[0]);
		double desiredAngle = Math.abs(Math.toDegrees(angle1 - angle2));
        //System.out.println(desiredAngle);
		return Math.abs(desiredAngle - 90.0) < 0.00001 || Math.abs(desiredAngle - 270.0) < 0.00001;
    }
}