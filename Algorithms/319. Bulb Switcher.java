class Solution {
    public int bulbSwitch(int n) {
        /*
            Brute force (failed)
                calculate times each bulb has been toggled and store the information in a map
        */
//         if (n == 0) return 0;
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for (int i = 2; i <= n; ++i) {
//             for (int j = 1; j <= n; ++j) {
//                 if (j % i == 0) {
//                     map.put(j, map.getOrDefault(j, 0) + 1);
//                 }
//             }
//         }
        
//         System.out.println(map);
        
//         int count = 0;
//         for (int i : map.values()) {
//             if (i % 2 == 0) count++;
//         }
//         return count + 1;
        
        /*
            Brute force (failed)
                using array instead of map to store information
        */
//         int[] array = new int[n + 1];
        
//         for (int i = 1; i <= n; ++i) {
//             for (int j = i; j <= n; ++j) {
//                 if (j % i == 0) {
//                     array[j]++;
//                 }
//             }
//         }
        
//         int count = 0;
//         for (int i : array) {
//             if (i % 2 != 0) {
//                 count++;
//             }
//         }
//         return count;
        
        /*
            Math
                Each bulb is toggled for each number lower than it that divides it evenly
                That is a bulb will be on iff it has an even number of unique divisors
                This happens only when a number is a perfect square since all divisors can be grouped in pairs
                so we only need to find out how many perfect square numbers are there less than or equals to n
        */
        int count = 0;
        for (int i = 1; i * i <= n; ++i) {
            count++;  
        }
        
        return count;
    }
}