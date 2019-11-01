class Solution {
    public int lengthOfLastWord(String s) {
        /*
            String
        */
        String[] array = s.split(" ");
        if (array.length == 0 || s.length() == 0) return 0;
        return array[array.length - 1].length();
    }
}