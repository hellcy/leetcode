class Solution {
    public boolean checkOnesSegment(String s) {
        int count = 0;
        String[] arr = s.split("0");
        for (String str : arr) {
            if (str.length() >= 1) {
                count++;
            }
        }
        
        return count == 1;
    }
}