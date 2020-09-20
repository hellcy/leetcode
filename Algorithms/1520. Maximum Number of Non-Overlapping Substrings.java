class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        /*
            1. get start and end index for each charater
            2. for each character, try to iterate through all other characters within range and try to expand range to include all appearance. this will get a valid substring
            3. Note: not all valid substring will be found, for example, if the input is 'aabb', then 'aa' and 'bb' will be found, but 'aabb' will not, however, this will not affect the final answer as we want the maximum number of substring with minumum total length.
        */
        
        Map<Character, int[]> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            
            if (map.containsKey(c)) {
                int[] arr = map.get(c);
                arr[1] = Math.max(arr[1], i);
            } else {
                int[] newarr = new int[2];
                newarr[0] = i;
                newarr[1] = i;
                map.put(c, newarr);
            }
        }
        
        Map<String, int[]> strs = new HashMap<>();
        
        for (char c : map.keySet()) {
            int[] arr = map.get(c);
            //System.out.println(c + " " + map.get(c)[0] + " " + map.get(c)[1]);
            for (int i = arr[0]; i <= arr[1]; ++i) {
                char current = s.charAt(i);
                if (current == c) continue;
                else {
                    int[] temp = map.get(current);
                    if (arr[0] > temp[0]) {
                        arr[0] = temp[0];
                        i = arr[0];
                    }
                    if (arr[1] < temp[1]) {
                        arr[1] = temp[1];
                        i = arr[0];
                    }
                }
            }
            
            String key = s.substring(arr[0], arr[1] + 1);
            //System.out.println(key);
            if (!strs.containsKey(key)) {
                strs.put(key, arr);
            }
        }
        
        List<int[]> intervals = new ArrayList<>();
        for (String str : strs.keySet()) {
            //System.out.println(str + " " + strs.get(str)[0] + " " + strs.get(str)[1]);
            int length = str.length();
            int[] arr = {strs.get(str)[0], strs.get(str)[1], length};
            intervals.add(arr);
        }
        
        int count = 1, max = 1;
        Collections.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        int currentmax = 0;
        List<String> list = new ArrayList<>();
        int[] current = intervals.get(0);
        list.add(s.substring(current[0], current[1] + 1));
        currentmax = current[1];
            
        for (int i = 1; i < intervals.size(); ++i) {
            int[] temp = intervals.get(i);
            if (currentmax < temp[0]) {
                currentmax = temp[1];
                list.add(s.substring(temp[0], temp[1] + 1));
            }
        }

        return list;
    }
}