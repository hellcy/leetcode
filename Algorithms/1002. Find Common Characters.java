class Solution {
    public List<String> commonChars(String[] A) {
        /*
            Algorithm explained:
                create two list of strings
                only add string to the second list if the string also appears in the first list
                clear the first list and copy from second list after each iteration
        */
        List<String> list = new ArrayList<>();
        int n = A.length;
        char[] array = A[0].toCharArray();
        for (int i = 0; i < array.length; ++i) {
            list.add(String.valueOf(array[i]));
        }
        
        for (int i = 0; i < n; ++i) {
            char[] string = A[i].toCharArray();
            List<String> commonList = new ArrayList<>();
            for (int j = 0; j < string.length; ++j) {
                String s = String.valueOf(string[j]);
                if (list.contains(s)) {
                    list.remove(s);
                    commonList.add(s);
                }
            }
            list.clear();
            list.addAll(commonList);
        }
        
        return list;
    }
}