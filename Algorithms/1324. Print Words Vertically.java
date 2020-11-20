class Solution {
    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        int max = 0;
        for (String str : arr) {
            max = Math.max(max, str.length());
        }
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < max; ++i) {
            String str = "";
            for (int j = 0; j < arr.length; ++j) {
                if (arr[j].length() > i) {
                    str += arr[j].substring(i, i + 1);
                } else {
                    str += " ";
                }
            }
            
            list.add(helper(str));
        }
        
        // for (String str : list) {
        //     System.out.println(str);
        // }
        return list;
    }
    
    private String helper(String str) {
        for (int i = str.length() - 1; i >= 0; --i) {
            if (str.charAt(i) != ' ') {
                str = str.substring(0, i + 1);
                break;
            }
        }
        return str;
    }
}