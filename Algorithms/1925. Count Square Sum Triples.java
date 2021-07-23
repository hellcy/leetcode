class Solution {
    public int countTriples(int n) {
        int count = 0;
        
        // Brute force
        // for (int i = 1; i <= n; ++i) {
        //     for (int j = 1; j <= n; ++j) {
        //         for (int k = 1; k <= n; ++k) {
        //             if (Math.pow(i, 2) + Math.pow(j, 2) == Math.pow(k, 2)) count++;
        //         }
        //     }
        // }
        
        // for each pair a and b, check if the square root of (a^2 + b^2) is an integer less than or equal to n
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                double num = Math.sqrt(Math.pow(i, 2) + (int)Math.pow(j, 2));
                if (num - Math.floor(num) == 0 && num <= n) count++;
            }
        }
        return count;
    }
}