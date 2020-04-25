class Solution {
    public int findLucky(int[] arr) {
        /*
            Array
            Sort
        */
        Arrays.sort(arr);
        
        int number = arr[0];
        int count = 1;
        int ans = -1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] == number) {
                count++;
            } else {
                //System.out.println(number);
                if (count == number) {
                    if (ans < number) ans = number;
                }
                count = 1;
                number = arr[i];
            }
        }
        
        if (count == number) {
            if (ans < number) ans = number;
        }
        
        return ans;
    }
}