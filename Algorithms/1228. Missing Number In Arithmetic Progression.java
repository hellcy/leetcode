class Solution {
    public int missingNumber(int[] arr) {
        /*
            Array
            Math
                calculate two differences and the values
        */
        int differA = 0, differB = 0;
        int valueA = 0, valueB = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (differA == 0) {
                valueA = arr[i - 1];
                differA = arr[i] - arr[i - 1];
            } else if (arr[i] - arr[i - 1] != differA) {
                valueB = arr[i - 1];
                differB = arr[i] - arr[i - 1];
            } else if (differA != 0 && differB != 0) {
                break;
            }
        }
        //System.out.println(differA + " " + differB);
        //System.out.println(valueA + " " + valueB);
        if (differA == 2 * differB) {
            return valueA + differB;
        } else {
            return valueB + differA;
        }
        
    }
}