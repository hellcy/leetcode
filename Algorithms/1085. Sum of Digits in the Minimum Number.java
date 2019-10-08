class Solution {
    public int sumOfDigits(int[] A) {
        /*
            Math min and Modulu
        */
        int min = Integer.MAX_VALUE;
        
        for (int i : A) {
            min = Math.min(min, i);
        }
        
        int sum = 0;
        while (min >= 1) {
            sum += min % 10;
            min = min / 10;
        }
        
        if (sum % 2 == 0) return 1;
        else return 0;
    }
}