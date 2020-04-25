class Solution {
    public int singleNumber(int[] nums) {
        /*
            Algorithm explained:
                HashMap
                create a map to store nums and the time of appearance
                traverse the map to find the value that is 1, return its key
        */
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for(int i : nums) {
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }
        
//         for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//             if (e.getValue() == 1) return e.getKey();
//         }
//         throw null;
        
        /*
            Bit Manipulation
                Since we can use XOR to toggle a bit, so b ^ b = 0 and b ^ 0 = b
                we know their is exactly one int that appears only once
                so use XOR on all integers of the array would give us the answer becasue all other int will cancelled out
        */
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
        
    }
}