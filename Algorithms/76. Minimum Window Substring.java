class Solution {
    public String minWindow(String s, String t) {
        /*
            sliding window
            hashmap
        */
//         int index = 0;
//         String min = "";
//         int minlength = Integer.MAX_VALUE;
        
//         Map<Character, Integer> mapa = new HashMap<>();
//         Map<Character, Integer> mapb = new HashMap<>();
//         for (char c : t.toCharArray()) {
//             mapb.put(c, mapb.getOrDefault(c, 0) + 1);
//         }
        
//         for (int i = 0; i < s.length(); ++i) {
//             while (index < s.length() && !valid(mapa, mapb)) {
//                 mapa.put(s.charAt(index), mapa.getOrDefault(s.charAt(index), 0) + 1);
//                 index++;
//             }
            
//             if (valid(mapa, mapb)) {
//                 if (index - i + 1 < minlength) {
//                     min = s.substring(i, index);
//                     minlength = index - i + 1;
//                 }
//             }
//             char c = s.charAt(i);
//             mapa.put(c, mapa.get(c) - 1);
//         }
//         return min;
        
        /*
          same as method above, but use 256 length array instead of hashmap  
        */
        int index = 0;
        String min = "";
        int minlength = Integer.MAX_VALUE;
        
        int[] sarray = new int[256];
        int[] tarray = new int[256];
        for (char c : t.toCharArray()) {
            tarray[c]++;
        }
        
        for (int i = 0; i < s.length(); ++i) {
            while (index < s.length() && !validarray(sarray, tarray)) {
                sarray[s.charAt(index)]++;
                index++;
            }
            
            if (validarray(sarray, tarray)) {
                if (index - i + 1 < minlength) {
                    min = s.substring(i, index);
                    minlength = index - i + 1;
                }
            }
            char c = s.charAt(i);
            sarray[c]--;
        }
        return min;
    }
    
    private boolean valid(Map<Character, Integer> mapa, Map<Character, Integer> mapb) {
        for (char c : mapb.keySet()) {
            if (!mapa.containsKey(c)) {
                return false;
            }
            if (mapa.get(c) < mapb.get(c)) return false;
        }
        return true;
    }
    
    private boolean validarray(int[] a, int[] b) {
        for (int i = 0; i < 256; ++i) {
            if (b[i] > a[i]) return false;
        }
        return true;
    }
}