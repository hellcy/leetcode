class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        int[] array = new int[26];
        
        int first = 0, second = 2;
        int length = s.length();
        if (length < 3) return count;
        
        for (int i = 0; i < 3; ++i) {
            array[s.charAt(i) - 'a']++;
        }
        
        if (check(array)) count++;
        
        while (second < length - 1) {
            array[s.charAt(first++) - 'a']--;
            array[s.charAt(++second) - 'a']++;
            if (check(array)) count++;
        }
        return count;
    }
    
    private boolean check(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num == 1) count++;
        }
        
        return count == 3;
    }
}