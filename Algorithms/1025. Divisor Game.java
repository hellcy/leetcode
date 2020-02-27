class Solution {
    public boolean divisorGame(int N) {
        /*
            Dynamic programming
        */
        if (N == 1 || N == 3) return false;
        else if (N == 2) return true;
        
        int[] array = new int[N + 1];
        array[1] = 2; // Lose
        array[2] = 1; // Win
        array[3] = 2; // Lose
        
        for (int i = 4; i <= N; ++i) {
            boolean flag = false;
            for (int j = 1; j * j < i; ++j) {
                if (i % j == 0 && array[i - j] == 2) {
                    array[i] = 1;
                    flag = true;
                    break;
                } else if (i % (i - j) == 0 && array[j] == 2) {
                    array[i] = 1;
                    flag = true;
                    break;
                }
            }
            
            if (!flag) array[i] = 2;
        }
        
        if (array[N] == 1) return true;
        else return false;
    }
}