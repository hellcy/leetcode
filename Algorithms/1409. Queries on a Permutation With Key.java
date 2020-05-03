class Solution {
    public int[] processQueries(int[] queries, int m) {
        /*
            HashMap
            keep track of the number and its index in the array
            when we pick a number and move it to the begining of the array,
            we add one to the index for all numbers that have index smaller then the number we picked
        */
        int[] ans = new int[queries.length];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 1; i <= m; ++i) {
            map.put(i, i - 1);
        }
        
        for (int i = 0; i < queries.length; ++i) {
            int number = queries[i];
            ans[i] = map.get(number);          
            for (int key : map.keySet()) {
                if (map.get(key) < map.get(number)) {
                    map.put(key, map.get(key) + 1);
                }
            }
            map.put(number, 0);
            //System.out.println(map);
        }
        
        return ans;
    }
}