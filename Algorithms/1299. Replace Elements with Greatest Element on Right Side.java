class Solution {
    public int[] replaceElements(int[] arr) {
        /*
            Array
        */
        int[] newarray = new int[arr.length];
        
        for (int i = 0; i < arr.length - 1; ++i) {
            newarray[i] = largest(Arrays.copyOfRange(arr, i + 1, arr.length));
        }
        
        newarray[arr.length - 1] = -1;
        
        return newarray;
    }
    
    private int largest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}