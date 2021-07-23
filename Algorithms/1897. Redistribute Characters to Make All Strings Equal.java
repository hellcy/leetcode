class Solution {
    public boolean makeEqual(String[] words) {
        int[] array = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                array[c - 'a']++;
            }
        }
        
        for (int num : array) {
            if (num % words.length != 0) return false;
        }
        return true;
    }
}