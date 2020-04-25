class Solution {
    public char findTheDifference(String s, String t) {
        /*
            HashSet
                all element will occur (2 * x) times except the results char will only occur once
                so the final set will only contain one char, which is the result
        */
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
            }
        }
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
            }
        }
        return (char)set.toArray()[0];
        
        
//         Map<Character, Integer> smap = new HashMap<>();
//         Map<Character, Integer> tmap = new HashMap<>();
        
//         for (int i = 0; i < s.length(); ++i) {
//             smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
//         }
//         for (int i = 0; i < t.length(); ++i) {
//             tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
//         }
        
//         for (Character c : tmap.keySet()) {
//             if (tmap.get(c) != smap.get(c)) {
//                 return c;
//             }
//         }
//         throw null;
    }
}