class Solution {
    public String reverseStr(String s, int k) {
        /*
            String
        */
        StringBuilder str = new StringBuilder();
        int count = k;
        int times = 1;
        boolean flag = true, lastreverse = false;
        
        for (int i = 0; i < s.length(); ++i) {
            if (flag) {
                if (count > 0) {
                    //System.out.println(str.toString() + " " + s.charAt(times * k - 1 - k + count));
                    
                    if (lastreverse || times * k - 1 - k + count > s.length() - 1) {
                        lastreverse = true;
                        str.append(s.charAt(s.length() - 1 - k + count));
                    } else {
                        str.append(s.charAt(times * k - 1 - k + count));
                    }
                    
                    count--;
                } else {
                    flag = false;
                    times++;
                }
            }
            
            if (!flag) {
                if (count < k) {
                    str.append(s.charAt(i));
                    count++;
                } else {
                    flag = true;
                    i--;
                    times++;
                }
            }
        }
        
        return str.toString();
    }
}