class Solution {
    public int minimumSum(int num) {
        // put larger numbers into least significant position
        
        int[] array = new int[4];
        int index = 0;
        while (num > 0) {
            array[index] = num % 10;
            num /= 10;
            index++;
        }
        
        Arrays.sort(array);
        return array[3] + array[2] + array[1] * 10 + array[0] * 10;
    }
}