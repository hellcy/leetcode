class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        /*
            Algorithm explained:
                every time we calculate the sum by multiply the previous sum by 2 and add the least significant bit
                modulo the sum by 5 to prevent sum from overflowing
        */
        int n = A.length;
        List<Boolean> list = new ArrayList<>();
        int number = 0;
        for (int i = 0; i < n; ++i) {
            number = number * 2 + A[i];
            if (number % 5 == 0) list.add(true);
            else list.add(false);
            number = number % 5;
        }
        
        return list;
    }
}