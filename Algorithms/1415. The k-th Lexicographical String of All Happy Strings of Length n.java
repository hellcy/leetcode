class Solution {
    /*
        Backtracking
        add valid happy strings to the list until list size is equals to k
    */
    List<String> list = new ArrayList<>();
    int count = 0;
    public String getHappyString(int n, int k) {
        count = k;
        String str = "";
        String[] array = new String[3];
        array[0] = "a";
        array[1] = "b";
        array[2] = "c";
        helper(str, array, n);
        //System.out.println(list);
        if (list.size() >= k) return list.get(k - 1);
        return "";
    }
    
    private void helper(String str, String[] array, int n) {
        if (str.length() == n) {
            list.add(str);
        } else {
            if (list.size() < count) {
                for (int i = 0; i < array.length; ++i) {
                    
                    if (str.length() >= 1 && str.substring(str.length() - 1).equals(array[i])) {
                        //System.out.println(str + " " + str.substring(str.length() - 1));
                        continue;
                    }
                    //String copystr = str + array[i];
                    str += array[i];
                    helper(str, array, n);
                    str = str.substring(0, str.length() - 1);
                }
            }
        }
    }
}