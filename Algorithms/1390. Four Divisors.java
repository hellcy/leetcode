class Solution {
    public int sumFourDivisors(int[] nums) {
        /*
            Math
            Find divisors of a integer, only find to its square root, find two divisors in one time
        */
        int total = 0;
        for (int i : nums) {
            total += addDivisor(i);
        }
        
        return total;
    }
    
    private int addDivisor(int num) {
        int count = 0;
        int total = 0;
        for (int i = 1; i * i <= num; ++i) {
            if (num % i == 0) {
                total += i;
                count++;
                if (i != (num / i) && num % (num / i) == 0) {
                    total += (num / i);
                    count++;
                }
            }
        }
        
        if (count != 4) return 0;
        //System.out.println(total);
        return total;
    }
}