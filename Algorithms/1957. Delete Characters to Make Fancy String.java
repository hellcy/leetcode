class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        char current = s.charAt(0);
        ans.append(current);
        int index = 0;
        for (char c : s.toCharArray()) {
            if (index == 0) {
                index++;
                continue;
            }
            
            if (c == current) {
                count++;
            } else {
                count = 0;
            }
            
            if (count < 2) {
                ans.append(c);
            }
            
            index++;
            current = c;
        }
        
        return ans.toString();
    }
}