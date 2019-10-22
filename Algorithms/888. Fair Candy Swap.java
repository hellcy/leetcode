class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        /*
            Algorithm explained:
                if Bob has a candy that is exactly greater than the target value of current's Alice candy, then we found the answer
        */
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.length; ++i) {
            sumA += A[i];
        }
        
        for (int i = 0; i < B.length; ++i) {
            sumB += B[i];
        }
        
        int target = (sumB - sumA) / 2;
        Set<Integer> setB = new HashSet();
        for (int x: B) setB.add(x);

        for (int x: A)
            if (setB.contains(x + target))
                return new int[] {x, x + target};

        throw null;
    }
}