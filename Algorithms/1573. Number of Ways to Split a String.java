class Solution {
    public int numWays(String s) {
        int mod = (int)1e9 + 7;
        
        long one = 0, zero = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') one++;
            else zero++;
        }
        long ans = 0;
        if (one == 0) {
            ans = (zero - 1) * (zero - 2) / 2;   
            return (int)(ans % mod);
        }
        if ((one < 3 && one != 0) || one % 3 != 0) return 0;
        
        int onepergroup = (int)one / 3;
        
        long left = 0, right = 0;
        
        int currentone = 0;
        int currentgroup = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                if (currentone < onepergroup) currentone++;
                else {
                    currentone = 1;
                    currentgroup++;
                }
            } else {
                if (currentone == onepergroup) 
                {
                     if (currentgroup == 0) {
                        left++;
                    } else if (currentgroup == 1) {
                        right++;
                    }   
                }
            }
        }
        //System.out.println(left + " " + right);
        ans = (left + 1) * (right + 1);
        //System.out.println(ans);

        return (int)(ans % mod);
    }
}