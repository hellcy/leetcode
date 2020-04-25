class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        /*
            Algorithm explained:
                for each query, we keep track of the values in A before and after changing
                and assign sum of evens to array based on the parity of these values
                if before is odd and after is even, we add after to the sum
                if before is even and after is even too, we add after and substruct before
                if before is even and after is odd, we only substruct before from the sum
        */
        int n = A.length;
        int[] array = new int[n];
        int sum = 0;
        
        for (int i : A) if (i % 2 == 0) sum += i;
        boolean isOdd = false;
        for (int i = 0; i < n; ++i) {
            isOdd = false;
            if (A[queries[i][1]] % 2 != 0) isOdd = true;
            
            int before = A[queries[i][1]];
            A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
            int after = A[queries[i][1]];
            
            if (isOdd && after % 2 == 0) sum += after;
            else if (!isOdd && after % 2 == 0) sum += after - before;
            else if (!isOdd && after % 2 != 0) sum += - before;
            
            array[i] = sum;
        }
        
        return array;
    }
}