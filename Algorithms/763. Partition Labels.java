class Solution {
    public List<Integer> partitionLabels(String S) {
        int count = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        Set<Character> set = new HashSet<>();
        for (char c : S.toCharArray()) {
            if (!set.isEmpty()) {
                count++;
            } else {
                if (count != 0) list.add(count);
                count = 1;
            }
            
            set.add(c);
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
                set.remove(c);
            }
        }
        list.add(count);
        return list;
        
    }
}