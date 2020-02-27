class Solution {
    public int findJudge(int N, int[][] trust) {
        /*
            Array
                judge trust nobody, so change people value to -1 if they trust someone
                
                if there is more than one judge, return false
                
                check if there is N - 1 people trust judge
        */
        int[] array = new int[N];
        for (int i = 0; i < trust.length; ++i) {
            array[trust[i][0] - 1] = -1;
        }
        
        int judge = -1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == 0) {
                if (judge == -1) judge = i + 1;
                else return -1;
            }
        }
        
        int count = 0;
        for (int i = 0; i < trust.length; ++i) {
            if (trust[i][1] == judge) count++;
        }
        
        if (count == N - 1) return judge;
        else return -1;
    }
}