class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        /*
            Max steps is the distance between max value and min value - 2, one for the index, the other for the stone in between
            Min steps can either be 1 or 0
                if distance from middle stone to both two other stones are greater than 2, we need 2 steps
                otherwise we need 1 step
        */
        int[] array = {a, b, c};
        Arrays.sort(array);
        if (Math.abs(array[0] - array[2]) == 2) return new int[] {0, 0};
        int[] ans = new int[2];
        if (Math.abs(array[1] - array[0]) <= 2 || Math.abs(array[1] - array[2]) <= 2) {
            ans[0] = 1;
        } else {
            ans[0] = 2;
        }
        
        ans[1] = Math.abs(array[0] - array[2]) - 2;
        
        return ans;
    }
}