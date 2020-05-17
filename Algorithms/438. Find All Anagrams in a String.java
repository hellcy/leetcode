class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /*
            HashMap
        */
        int[] array = new int[26];
        for (char c : p.toCharArray()) {
            array[c - 'a']++;
        }
        
        int length = p.length();
        List<Integer> list = new ArrayList<>();
        
        if (s.length() < length) return list;
        
        int[] arr = new int[26];
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        for (int i = 0; i <= s.length() - length; ++i) {
            if (i > 0) {
                char c = s.charAt(i + length - 1);
                arr[c - 'a']++;
            }
            if (check(arr, array)) {
                list.add(i);
            }
            char c2 = s.charAt(i);
            arr[c2 - 'a']--;
        }
        
        return list;
    }
    
    private boolean check(int[] arr, int[] array) { 
        for (int i = 0; i < array.length; ++i) {
            if (arr[i] != array[i]) return false;
        }
        return true;
    }
}