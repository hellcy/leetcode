class Solution {
    public String[] sortFeatures(String[] features, String[] responses) {
        /*
            HashMap + Entry + Sort
            Each entry in map has feature name as key
            value is a array with length of 2
            arr[0] = index in features array
            arr[1] = occurrence times
        */
        Map<String, int[]> map = new HashMap<>();

        for (int i = 0; i < features.length; ++i) {
            int[] arr = new int[2];
            arr[0] = i;
            map.put(features[i], arr);
        } 

        for (String str : responses) {
            String[] list = str.split(" ");
            Set<String> set = new HashSet<>();
            for (String cur : list) {
                if (!set.contains(cur) && map.containsKey(cur)) {
                    set.add(cur);
                    map.get(cur)[1]++;
                }
            }
        }
        
        String[] ans = new String[features.length];
        List<Map.Entry<String, int[]>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, int[]>>() {
            public int compare(Map.Entry<String, int[]> a, Map.Entry<String, int[]> b) {
                return a.getValue()[1] == b.getValue()[1] ? a.getValue()[0] - b.getValue()[0] : b.getValue()[1] - a.getValue()[1];
            }
        });

        int index = 0;
        for (Map.Entry<String, int[]> entry : list) {
            ans[index] = entry.getKey();
            //System.out.println(entry.getKey() + " " + entry.getValue()[1]);
            index++;
        }

        return ans;
    }
}