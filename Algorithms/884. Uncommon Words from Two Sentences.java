class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        /*
            HashMap
            if value in Amap equals to 1 and key not in Bmap, we add it to list
            meanwhile, to increase speed, remove key from Bmap because its invalid
        */
        Map<String, Integer> Amap = new HashMap<>();
        Map<String, Integer> Bmap = new HashMap<>();
        String[] Aarray = A.split(" ");
        String[] Barray = B.split(" ");
        for (String s : Aarray) {
            Amap.put(s, Amap.getOrDefault(s, 0) + 1);
        }
        for (String s : Barray) {
            Bmap.put(s, Bmap.getOrDefault(s, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for (String s : Amap.keySet()) {
            if (Amap.get(s) == 1 && !Bmap.containsKey(s)) {
                list.add(s);
            } else {
                Bmap.remove(s);
            }
        }
        
        for (String s : Bmap.keySet()) {
            if (Bmap.get(s) == 1 && !Amap.containsKey(s)) {
                list.add(s);
            }
        }
        
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}