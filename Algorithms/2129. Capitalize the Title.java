class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        
        StringBuilder ans = new StringBuilder();
        
        for (String word : words) {
            if (word.length() <= 2) {
                for (char c : word.toCharArray()) {
                    ans.append(toLower(c));
                }
                ans.append(' ');
            } else {
                boolean first = true;
                for (char c : word.toCharArray()) {
                    if (first) {
                        ans.append(toUpper(c));
                        first = !first;
                    } else {
                        ans.append(toLower(c));
                    }
                }
                ans.append(' ');
            }
        }
        
        return ans.toString().substring(0, ans.length() - 1);
    }
    
    public char toLower(char c) {
        if (c - 'a' < 0) {
            return (char)(c - 'A' + 'a');
        }
        return c;
    }
    
    public char toUpper(char c) {
        if (c - 'a' >= 0) {
            return (char)(c - 'a' + 'A');
        }
        
        return c;
    }
}