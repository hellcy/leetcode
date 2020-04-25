class Solution {
    /*
        Backtracking
            check if string start with bracket '{', if it is, find the next '}'
            call helper funcation for each character in between
            if not start with '{', add the next character to the combination and call helper for next round
    */
    Set<String> set = new HashSet<>();
    public String[] expand(String S) {
        
        helper("", S);
        String[] array = new String[set.size()];
        int i = 0;
        for (String s : set) {
            array[i] = s;
            i++;
        }
        Arrays.sort(array);
        return array;
    }
    
    private void helper(String combination, String s) {
        //System.out.println(combination + " " + s);
        if (s.length() == 0) {
            set.add(combination);
            return;
        }
        
        int index = 0;
        String temp = "";
        if (s.charAt(0) == '{') {
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '}') {
                    index = i;
                    temp = s.substring(0, i);
                    break;
                }
            }
            
            for (int i = 0; i < temp.length(); ++i) {
                if (temp.charAt(i) < 97 || temp.charAt(i) > 122) continue;
                else {
                    helper(combination + temp.substring(i, i + 1), s.substring(index + 1));
                }
            }
        } else {
            helper(combination + s.substring(0, 1), s.substring(1));
        }
    }
}