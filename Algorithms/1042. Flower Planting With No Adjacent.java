class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        /*
            Map + adjcent list
        */
        
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 1; i <= n; ++i) {
            Set<Integer> set = new HashSet<>();
            
            adj.put(i, set);
        }
        
        for (int[] array : paths) {
            adj.get(array[0]).add(array[1]);
            adj.get(array[1]).add(array[0]);
        }
                
        for (int i = 1; i <= n; ++i) {
            boolean[] visited = new boolean[4];
            for (int j : adj.get(i)) {
                if (map.containsKey(j)) {
                    visited[map.get(j) - 1] = true;
                }
            }
                        
            for (int k = 0; k < 4; ++k) {
                //System.out.println(visited[k]);
                if (!visited[k]) {
                    map.put(i, k + 1);
                    break;
                }
            }
            //System.out.println(map);
        }
        
        int[] ans = new int[n];
        
        int index = 0;
        for (int key : map.keySet()) {
            ans[index] = map.get(index + 1);
            index++;
        }
        
        return ans;
    }
}