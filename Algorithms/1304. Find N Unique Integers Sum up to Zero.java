class Solution {
    /*
        Array
    */
    public int[] sumZero(int n) {
        int[] array = new int[n];
        int number = 1;
        
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i = i + 2) {
                array[i] = number;
                array[i + 1] = -number;
                number++;
            }
            
        } else {
            for (int i = 0; i < n - 2; i = i + 2) {
                array[i] = number;
                array[i + 1] = -number;
                number++;
            }
            array[n - 1] = 0;
        }

        
        return array;
    }
}