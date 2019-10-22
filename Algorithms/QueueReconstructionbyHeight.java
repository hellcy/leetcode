class Solution {
    public int[][] reconstructQueue(int[][] people) {
        /*
            Priority Queue 
        */
        Arrays.sort(people, (x, y) -> x[0] - y[0]);
        int[][] ans = new int[people.length][2];
        for (int[] row : ans) 
            Arrays.fill(row, -1);
        
        for (int i = 0; i < people.length; ++i) {
            int count = 0;
            for (int j = 0; j < ans.length; ++j) {
                if (count >= people[i][1] && ans[j][0] == -1) {
                    ans[j] = people[i];
                    break;
                }
                if ((ans[j][0] == -1 || ans[j][0] >= people[i][0]) && count < people[i][1]) {
                    //System.out.println(people[i][0] + " " + people[i][1]);
                    count++;
                }
            }
        }
        
        return ans;
    }
}