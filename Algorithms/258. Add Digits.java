class Solution {
    public int addDigits(int num) {
        /*
            do while loop
        */
//         int count = num;
//         do {
//             num = count;
//             count = 0;
//             while (num >= 1) {
//                 count += num % 10;
//                 num = num / 10;
//             }
//         } while (count >= 10);
        
//         return count;
        
        /*
            Math
                the answer can only be from 1 to 9, so modulu the num by 9 will give the answer
        */
        if (num == 0) return num;
        
        num = num % 9;
        if (num == 0) return 9;
        else return num;
    }
}