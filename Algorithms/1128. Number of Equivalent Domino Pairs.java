class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        /*
            Algorithm explained:
                create a hashmap
                for each domino, create two int to break the order
                put each domino in the map
                count the permutations
        */
        int length = dominoes.length;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            int a = Math.max(dominoes[i][0], dominoes[i][1]);
            int b = Math.min(dominoes[i][0], dominoes[i][1]);
            
            map.put(String.valueOf(a) + " " + String.valueOf(b), map.getOrDefault(String.valueOf(a) + " " + String.valueOf(b), 0) + 1);
        }
        
        int count = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            count += e.getValue() * (e.getValue() - 1) / 2;
        }
        
        return count;
    }
}