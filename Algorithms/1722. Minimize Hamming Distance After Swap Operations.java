class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        /*
            Union Find + HashMap
        */
        int n = source.length;
        int[] uf = new int[n];
        for (int i = 0; i < n; ++i) {
            uf[i] = i;
        }
        
        for (int[] arr : allowedSwaps) {
            int a_root = find(uf, arr[0]);
            int b_root = find(uf, arr[1]);
            if (a_root != b_root) {
                uf[a_root] = b_root;
            }
        }
        
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            int root = find(uf, i);
            if (!map.containsKey(root)) {
                Map<Integer, Integer> valuemap = new HashMap<>();
                map.put(root, valuemap);
            }
            
            Map<Integer, Integer> temp = map.get(root);
            temp.put(source[i], temp.getOrDefault(source[i], 0) + 1);
        }
        
        //System.out.println(map);
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int root = find(uf, i);
            Map<Integer, Integer> valuemap = map.get(root);
            
            if (valuemap.containsKey(target[i])) {
                valuemap.put(target[i], valuemap.get(target[i]) - 1);
                if (valuemap.get(target[i]) == 0) valuemap.remove(target[i]);
            } else {
                ans++;
            }
        }
        
        return ans;
    }
    
    private int find(int[] arr, int x) {
        if (arr[x] == x) return x;
        return arr[x] = find(arr, arr[x]);
    }
}