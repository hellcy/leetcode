class Solution {
    /*
        Sort
        Array
    */
    public String sortString(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        List<Character> list = new ArrayList<>();
        
        for (char c : array) list.add(c);
        StringBuilder str = new StringBuilder();
        Character prev = null;
        while (list.size() > 0) {
            for (int i = 0; i < list.size(); ++i) {
                if (i == 0 && prev == null) {
                    str.append(list.get(i));
                    prev = list.get(i);
                    list.remove(i);
                    i--;
                } else if (prev != list.get(i)) {
                    str.append(list.get(i));
                    prev = list.get(i);
                    list.remove(i);
                    i--;
                }
            }
            prev = null;
            
            for (int i = list.size() - 1; i >= 0; --i) {
                if (i == list.size() - 1 && prev == null) {
                    str.append(list.get(i));
                    prev = list.get(i);
                    list.remove(i);
                } else if (prev != list.get(i)) {
                    str.append(list.get(i));
                    prev = list.get(i);
                    list.remove(i);
                }
            }
            prev = null;
        }
        
        

        return str.toString();
    }
}