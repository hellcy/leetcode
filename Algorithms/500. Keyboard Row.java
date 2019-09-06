class Solution {
    public String[] findWords(String[] words) {
        /*
            Brute force
                for each string
                    for each keyboard row
                        for each character in string
                            check if this character is contained in the keyboard row
                        if all characters from the string are contained in one row, add it to the ans
        */
        List<String> ansList = new ArrayList<>();
        List<Set<Character>> list = new ArrayList<>();
        Set<Character> set1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> set3 = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        
        list.add(set1);
        list.add(set2);
        list.add(set3);
        
        for (String s : words) {
            char[] cs = s.toLowerCase().toCharArray();
            for (Set<Character> set : list) {
                boolean flag = true;
                for (char c : cs) {
                    if (!set.contains(c)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) ansList.add(s);
            }
        }
        String[] ans = new String[ansList.size()];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}