class Solution {
    public boolean checkPerfectNumber(int num) {
        /*
            Brute force
        */
//         int total = 0;
//         if (num <= 0) return false;
        
//         for (int i = 1; i <= num / 2; ++i) {
//             if (num % i == 0) {
//                 total += i;
//             }
//         }
        
//         //System.out.println(total);
//         if (total == num) return true;
//         else return false;
        
        /*
            the largest number in such a pair can only be up to sqrt(num)
            Thus, we can get a significant reduction in the run-time by iterating only upto \sqrt{num} in a SINGLE pass directly.
        */
        int total = 0;
        
        if (num <= 0) return false;
        
        for (int i = 1; i * i <= num; ++i) {
            if (num % i == 0) {
                total += i;
                if (i * i != num) {
                    total += num / i;
                }
            }
        }
        
        return total - num == num;
    }
}