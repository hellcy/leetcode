class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder str = new StringBuilder();
        int index = 0;
        char[] array = new char[indices.length];
        for (char c : s.toCharArray()) {
            array[indices[index]] = c;
            index++;
        }
        
        for (char c : array) {
            str.append(c);
        }
        return str.toString();
    }
}