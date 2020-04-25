class Solution {
    public int calculateTime(String keyboard, String word) {
        /*
            HashMap
                store keyboard index information
        */
//         int current = 0;
//         Map<Character, Integer> map = new HashMap<>();
        
//         for (int i = 0; i < keyboard.length(); ++i) {
//             map.put(keyboard.charAt(i), i);
//         }
        
//         int count = 0;
//         for (int i = 0; i < word.length(); ++i) {
//             count += Math.abs(current - map.get(word.charAt(i)));
//             current = map.get(word.charAt(i));
//         }
        
//         return count;
        
        /*
            using string indexOf method
        */
        
        int current = 0;
        
        int count = 0;
        for (int i = 0; i < word.length(); ++i) {
            count += Math.abs(current - keyboard.indexOf(word.charAt(i)));
            current = keyboard.indexOf(word.charAt(i));
        }
        
        return count;
    }
}