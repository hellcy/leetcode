class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        /*
            Dynamic Programming
            Similar to Ugly Number 2
            Keep increment the index when its next possible ugly number is smaller then the current ugly number
        */
        int length = primes.length;
        int[] indexes = new int[length];
        int min = Integer.MAX_VALUE;
        int minindex = -1;
        
        if (n == 0) return 0;
        int[] array = new int[n];
        array[0] = 1;
        
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < length; ++j) {
                int number = array[indexes[j]] * primes[j];
                while (number <= array[i - 1]) {
                    indexes[j]++;
                    number = array[indexes[j]] * primes[j];
                }
                
                if (min > number) {
                    min = number;
                    minindex = j;
                } 
            }
            //System.out.println(min + " " + minindex + " " + indexes[minindex]);
            array[i] = min;
            indexes[minindex]++;
            min = Integer.MAX_VALUE;
        }
        
        return array[n - 1];
    }
}