class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        /*
            we only need to consider the first nut
            the distance saved is the distance between the tree to nut - the distance between nut to squirrel
            we need to visit every nut and calcualte Max(dis(tree, nut) - dis(squirrel, nut))
        */
        int maxdis = Integer.MIN_VALUE;
        int maxx = 0;
        int maxy = 0;

        for (int[] nut : nuts) {
            int curdis = Math.abs(tree[0] - nut[0]) + Math.abs(tree[1] - nut[1]) - Math.abs(squirrel[0] - nut[0]) - Math.abs(squirrel[1] - nut[1]);
            if (curdis > maxdis) {
                maxdis = curdis;
                maxx = nut[0];
                maxy = nut[1];
            }
        }
        
        int ans = 0;
        ans += Math.abs(squirrel[0] - maxx) + Math.abs(squirrel[1] - maxy);
        ans = ans - Math.abs(tree[0] - maxx) - Math.abs(tree[1] - maxy);

        for (int[] nut : nuts) {
            ans += (Math.abs(tree[0] - nut[0]) + Math.abs(tree[1] - nut[1])) * 2;
        }
        
        return ans;
    }
}