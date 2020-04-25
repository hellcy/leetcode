class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            Sliding window
                create fast and slow pointers and a hashset
                for each character, if not in set, add it to set, move fast pointer to next
                when we meet some character that is already in the set
                we know there is some character between slow and fast, everything before that character need to be removed
                so we keep moving slow to next, until set doesn't contain that character anymore
                also keep tracking the max distance between slow and fast pointers
        */
        Set<Character> set = new HashSet<>();
        int length = s.length();
        int fast = 0;
        int slow = 0;
        int max = 0;
        while (fast < length && slow < length) {
            char c = s.charAt(fast);
            if (!set.contains(c)) {
                set.add(c);
                fast++;
            } else {
                set.remove(s.charAt(slow));
                slow++;a
            }
            max = Math.max(max, fast - slow);
        }
                
        return max;
        
        /*
            Two pointers
            HashMap
            Sliding window
        */
//         int count = 0;
//         int max = 0;
//         Map<Character, Integer> map = new HashMap<>();
//         int fast = 0;
//         int slow = 0;
//         while (fast < s.length()) {
//             if (!map.containsKey(s.charAt(fast))) {
//                 count++;
//             } else {
//                 count = count - map.get(s.charAt(fast)) + slow;
//                 int temp = slow;
//                 slow = map.get(s.charAt(fast)) + 1;
//                 while (temp < slow) {
//                     map.remove(s.charAt(temp));
//                     temp++;
//                 }
//             }
//             map.put(s.charAt(fast), fast);
//             fast++;
//             max = Math.max(max, count);
//         }
        
//         return max;
    }
}