class Solution {
    public int numJewelsInStones(String J, String S) {
        /*
            Hash Map
                store S in a map
                for each character in J, check if map has the key,
                if has, add the value to the count
        */
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < S.length(); ++i) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }
        
        int count = 0;
        for (int i = 0; i < J.length(); ++i) {
            if (map.containsKey(J.charAt(i))) {
                count += map.get(J.charAt(i));
            }
        }
        
        return count;
    }
}