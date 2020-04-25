class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        /*
            HashMap
                group words into a key
                I use distance between each characters as the key 
                e.g. key for 'abc' is 11 because distance between a and b is 1 and between b and c is also 1
                key for az is 25
        */
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            char[] cs = s.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < cs.length; ++i) {
                int temp = cs[i] - cs[i - 1];
                if (temp < 0) temp += 26;
                builder.append(temp);
            }
            String key = builder.toString();
            //System.out.println(key);
            if (!map.containsKey(key)) {
                List<String> newlist = new ArrayList<>();
                newlist.add(s);
                map.put(key, newlist);
            } else {
                map.get(key).add(s);
            }
        }
        
        //System.out.println(map);
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        
        return list;
    }
}