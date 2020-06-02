class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        /*
            find the max length from horizontalCuts and verticalCuts
            be careful about the long type conversion
        */
        int m = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxh = horizontalCuts[0];
        int maxv = verticalCuts[0];
 
        for (int i = 1; i < horizontalCuts.length; ++i) {
            maxh = Math.max(maxh, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxh = Math.max(maxh, h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; ++i) {
            maxv = Math.max(maxv, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxv = Math.max(maxv, w - verticalCuts[verticalCuts.length - 1]);
        
        long ans = (long)maxh * maxv % m;

        return (int)ans;
    }
}