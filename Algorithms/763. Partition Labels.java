class Solution {
    public List<Integer> partitionLabels(String S) {
        /*
            HashMap
                Store the time of appearance into a map
                for each character, add into a set, and minus the time of appearance of that character by 1
                for all characters in the set, if their time of appearance are all zero, than we found a partition
        */
//         Map<Character, Integer> map = new HashMap<>();
        
//         for (int i = 0; i < S.length(); ++i) {
//             map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
//         }
        
//         Set<Character> set = new HashSet<>();
//         List<Integer> list = new ArrayList<>();
        
//         int prev = 0;
//         for (int i = 0; i < S.length(); ++i) {
//             boolean flag = true;
//             char c = S.charAt(i);
//             set.add(c);
//             if (map.get(c) > 0) {
//                 map.put(c, map.get(c) - 1);
//             }
//             for (char cc : set) {
//                 if (map.get(cc) != 0) {
//                     flag = false;
//                     break;
//                 }
//             }
//             if (flag) {
//                 set.clear();
                
//                 list.add(i + 1 - prev);
//                 prev = i + 1;
//             }
//         }
//         return list;
        
        /*
            Greedy
                for each characters, instead of keep tracking their time of appearance,
                we save its last appearance's index into a array
                for each character, we extend the current partition to its last appearance index
                then check the current index,
                if they are equal, then we found a partition
        */
        int[] array = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            array[S.charAt(i) - 'a'] = i;
        }
        
        List<Integer> list = new ArrayList<>();
        int prev = 0, index = 0;
        
        for (int i = 0; i < S.length(); ++i) {
            index = Math.max(index, array[S.charAt(i) - 'a']);
            if (i == index) {
                list.add(index + 1 - prev);
                prev = index + 1;
            }
        }
        
        return list;
    }
}