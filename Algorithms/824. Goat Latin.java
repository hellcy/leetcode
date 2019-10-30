class Solution {
    public String toGoatLatin(String S) {
        /*
            String
        */
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        String[] array = S.split(" ");
        String ans = "";
        for (int i = 0; i < array.length; ++i) {
            String as = "";
            for (int j = i; j >= 0; --j) {
                as += "a";
            }
            
            if (set.contains(array[i].charAt(0))) {
                ans += array[i] + "ma" + as + " ";
            } else {
                ans += array[i].substring(1) + array[i].substring(0, 1) + "ma" + as + " ";
            }
        }
        
        return ans.substring(0, ans.length() - 1);
    }
}