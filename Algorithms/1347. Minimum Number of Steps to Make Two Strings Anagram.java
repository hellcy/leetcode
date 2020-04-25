class Solution {
    public int minSteps(String s, String t) {
        /*
            HashMap
                store string information in a hashmap
                substract times of character occurance of t from hashmap
                adds all values of hashmap
        */
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        //System.out.println(map);
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            }
        }
        
        int count = 0;
        for (Character c : map.keySet()) {
            count += map.get(c);
        }
        return count;
        
        /*
            Double for loop
                TLE
        */
//         StringBuilder str = new StringBuilder(s);
        
//         for (int i = 0; i < t.length(); ++i) {
//             char c = t.charAt(i);
//             for (int j = 0; j < str.length(); ++j) {
//                 if (c == str.charAt(j)) {
//                     str.deleteCharAt(j);
//                     break;
//                 }
//             }
//         }
        
//         return str.length();
    }
}