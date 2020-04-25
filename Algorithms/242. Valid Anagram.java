class Solution {
    public boolean isAnagram(String s, String t) {
        /*
            HashMap
                compare two hashmaps
        */
//         HashMap<Character, Integer> map1 = new HashMap<>();
//         HashMap<Character, Integer> map2 = new HashMap<>();
        
//         for (char c : s.toCharArray()) {
//             map1.put(c, map1.getOrDefault(c, 0) + 1);
//         }
        
//         for (char c : t.toCharArray()) {
//             map2.put(c, map2.getOrDefault(c, 0) + 1);
//         }
        
//         //System.out.println(map1);
//         //System.out.println(map2);
        
//         if (map1.equals(map2)) return true;
//         else return false;
        
        /*
            Array
                note: a fixed 26 size of array can be used to store a string with number of occurance information
                array is a much smaller structure compared with map
        */
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        
        for(char c : s.toCharArray()) {
            array1[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            array2[c - 'a']++;
        }
        
        if (Arrays.equals(array1, array2)) return true;
        else return false;
    }
}