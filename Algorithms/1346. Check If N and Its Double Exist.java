class Solution {
    /*
        double for loop
        for every number N in the loop, check if 2N or N/2 is in the loop too
        think about odd values
    */
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            int number = arr[i];
            int one, two = 0;
            one = number * 2;
            
            boolean check = true;
            if (number % 2 == 0) {
                two = number / 2;
            } else {
                check = false;
            }
            
            for (int j = i + 1; j < arr.length; ++j) {
                if (check) {
                    if (arr[j] == one || arr[j] == two) {
                        return true;
                    } 
                } else {
                    if (arr[j] == one) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}