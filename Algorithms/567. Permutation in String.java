class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*
            Array
        */
        if (s1.length() > s2.length()) return false;
        int[] array = new int[26];
        
        for (char c : s1.toCharArray()) {
            array[c - 'a']++;
        }
        
        int length = s1.length();
        int[] arr = new int[26];
        
        for (int i = 0; i < length; ++i) {
            char c = s2.charAt(i);
            arr[c - 'a']++;
        }
        
        for (int i = 0; i <= s2.length() - length; ++i) {
            if (i > 0) {
                char c = s2.charAt(i + length - 1);
                arr[c - 'a']++;
            }
            if (check(array, arr)) return true;
            char c2 = s2.charAt(i);
            arr[c2 - 'a']--;
        }
        return false;
    }
    
    private boolean check(int[] array, int[] arr) {
        // for (int i = 0; i < arr.length; ++i) {
        //     System.out.print(arr[i] + " ");
        // }
        // System.out.println();
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != arr[i]) return false;
        }
        return true;
    }
}