class Solution {
    public int bitwiseComplement(int N) {
        /*
            Math
        */
        if (N == 0) return 1;
        String str = "";
        while (N >= 1) {
            if (N % 2 == 0) str += "0";
            else str += "1";
            N /= 2;
        }
        
        //System.out.println(str);
        
        String str2 = "";
        for (int i = str.length() - 1; i >= 0; --i) {
            char c = str.charAt(i);
            if (c == 48) str2 += "1";
            else str2 += "0";
        }
        
        //System.out.println(str2);
        
        int ans = 0, count = 0;
        
        for (int i = str2.length() - 1; i >= 0; --i) {
            char c = str2.charAt(i);
            ans += Math.pow(2, count) * (c - '0');
            count++;
            //System.out.println(ans);
        }
        
        return ans;
    }
    
    
}