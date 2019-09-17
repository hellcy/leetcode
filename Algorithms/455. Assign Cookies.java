{class Solution {
    public int findContentChildren(int[] g, int[] s) {
        /*
            Greedy
        */
        
        // sort both arrays
        Arrays.sort(g);
        Arrays.sort(s);
        
        int ng = g.length;
        int ns = s.length;
        
        // if either array is empty, return zero
        // if the smallest greed factor is greater than the largest cookie, return zero
        if (ng == 0 || ns == 0) return 0;
        else if (g[0] > s[ns - 1]) return 0;
        
        // calculate the index where the largest greed that is smaller than the largest cookie
        int index = 0;
        for (int i = ng - 1; i >= 0; --i) {
            if (s[ns - 1] >= g[i]) {
                index = i;
                break;
            }
        }
        
        
        int count = 0;
        int gstart = index;
        int sstart = ns - 1;
        
        // start from the index, using two pointers to find all cookies that are greater than greed
        while (gstart >= 0 && sstart >= 0) {
            if (s[sstart] >= g[gstart]) {
                count++;
                sstart--;
                gstart--;
            } else gstart--;
        }
        return count;
    }
}