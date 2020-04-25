class Solution {
    public int[] plusOne(int[] digits) {
        /*
            when we need to carry the most significant digit, create a new array with size + 1
        */
        int carry = 0;
        int plus = 1;
        if (digits[digits.length - 1] + 1 < 10) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] + plus + carry == 10) {
                plus = 0;
                carry = 1;
                digits[i] = 0;
            } else {
                carry = 0;
                digits[i] += 1;
                break;
            }
        }
        if (carry == 1) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            for (int i = 1; i < newArray.length; ++i) {
                newArray[i] = digits[i - 1];
            }
            return newArray;
        }
        return digits;
    }
}