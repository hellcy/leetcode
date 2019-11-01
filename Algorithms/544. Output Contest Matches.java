class Solution {
    public String findContestMatch(int n) {
        /*
            String
                split
                replace
            Recursion
            Math
                log (base 2)
        */
//         double count = Math.log(n) / Math.log(2);
//         String str = "";
//         for (int i = 1; i <= n; ++i) {
//             str += String.valueOf(i) + ",";
//         }
        
//         str = helper(str, count);
//         str = str.substring(0, str.length() - 1).replace(".", ",");
//         return str;
        
        /*
            DP
        */
        double count = Math.log(n) / Math.log(2);
        String[] array = new String[(int)count + 1];
        
        String str = "";
        for (int i = 1; i <= n; ++i) {
            str += String.valueOf(i) + ",";
        }
        array[0] = str;
        for (int i = 1; i < array.length; ++i) {
            array[i] = DPhelper(array[i - 1]);
            //System.out.println(array[i]);
        }
        
        String ans = array[(int)count];
        return ans.substring(0, ans.length() - 1).replace(".", ",");
    }
    
    private String helper(String s, double count) {
        //System.out.println(s + " " + (Math.log(n) / Math.log(2)));
        if (count <= 0) return s;
        
        String[] array = s.split(",");
        String str = "";
        for (int i = 0; i < array.length / 2; ++i) {
            str += "(" + array[i] + "." + array[array.length - 1 - i] + "),";
        }
        
        return helper(str, count - 1);
    }
    
    private String DPhelper(String s) {        
        String[] array = s.split(",");
        String str = "";
        for (int i = 0; i < array.length / 2; ++i) {
            str += "(" + array[i] + "." + array[array.length - 1 - i] + "),";
        }
        
        return str;
    }
}