class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        /*
            Algorithm explained:
                create a integer array large enough for holding all values from deck
                assign the number of appearance of each value in deck to the new array
                calculate the greatest common divisor for the whole array
                if gcd is equal or greater than 2, return true
        */
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int gcd = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (gcd == -1)
                    gcd = count[i];
                else
                    gcd = findGcd(gcd, count[i]);
            }

        return gcd >= 2;
    }
    
    private int findGcd(int a, int b) 
    { 
        if (a == 0) 
            return b; 
        return findGcd(b % a, a); 
    } 
}