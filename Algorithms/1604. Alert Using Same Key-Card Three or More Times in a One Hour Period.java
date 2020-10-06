class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        /*
            Map + Sliding window
            Group the times by the name of the card user, then sort each group
        */
        Map<String, List<String>> map2 = new HashMap<>();
        int n = keyName.length;

        for (int i = 0; i < n; ++i) {
            String name = keyName[i];
            String time = keyTime[i];
            if (map2.containsKey(name)) {
                map2.get(name).add(time);
            } else {
                List<String> list = new ArrayList<>();
                list.add(time);
                map2.put(name, list);
            }
        }
        
        for (String key : map2.keySet()) {
            Collections.sort(map2.get(key));
        } 
        
        List<String> ans = new ArrayList<>();
        
        for (String key : map2.keySet()) {
            List<String> list = map2.get(key);
            String[] array = new String[list.size()];
            for (int i = 0; i < array.length; ++i) {
                array[i] = list.get(i);
            }
            
            for (int i = 0; i < array.length - 2; ++i) {
                //System.out.println(array[i]);
                if (helper(array[i], array[i + 2])) {
                    ans.add(key);
                    break;
                }
            }
        }
        
        Collections.sort(ans);
        
        return ans;
    }
    
    private boolean helper(String prev, String current) {
        String[] prevlist = prev.split(":");
        String[] currentlist = current.split(":");

        int num1 = Integer.valueOf(prevlist[0]) * 60 + Integer.valueOf(prevlist[1]);
        int num2 = Integer.valueOf(currentlist[0]) * 60 + Integer.valueOf(currentlist[1]);
        
        return Math.abs(num1 - num2) <= 60;
    }
}