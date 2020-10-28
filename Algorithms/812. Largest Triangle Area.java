class Solution {
    public double largestTriangleArea(int[][] points) {
        /*
            some points cannot be formed into a triangle
            need to know how to calculate triangle area by three points
        */
        int n = points.length;
        double max = 0.0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (points[i][0] == points[j][0] && points[j][0] == points[k][0]) continue;
                    if (points[i][1] == points[j][1] && points[j][1] == points[k][1]) continue;
                    max = Math.max(max, helper(points[i], points[j], points[k]));
                }
            }
        }
        
        return max;
    }
    
    private double helper(int[] a, int[] b, int[] c) {
        return Math.abs(a[0] * (b[1] - c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1])) / 2.0;
    }
}