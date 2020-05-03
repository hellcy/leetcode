class Solution {
    public List<String> stringMatching(String[] words) {
        /*
            Brute force
            for each string check all other strings if they are substring of it
        */
        Set<String> set = new HashSet<>();
        int length = words.length;
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                if (i != j && check(words[i], words[j])) {
                    set.add(words[i]);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (String str : set) {
            ans.add(str);
        }
        return ans;
    }
    
    private boolean check(String a, String b) {
        if (a.length() > b.length()) return false;
        for (int i = 0; i < b.length(); ++i) {
            if (b.charAt(i) == a.charAt(0)) {
                if (i + a.length() <= b.length() && b.substring(i, i + a.length()).equals(a)) return true;
            }
        }
        
        return false;
    }
}