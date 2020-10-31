class Solution {
    public int minFlips(int a, int b, int c) {
        String str1 = "";
        String str2 = "";
        String str3 = "";
        
        while (a > 0) {
            if (a % 2 == 0) {
                str1 = "0" + str1;
            } else str1 = "1" + str1;
            a /= 2;
        }
        
        while (b > 0) {
            if (b % 2 == 0) {
                str2 = "0" + str2;
            } else str2 = "1" + str2;
            b /= 2;
        }
        
        while (c > 0) {
            if (c % 2 == 0) {
                str3 = "0" + str3;
            } else str3 = "1" + str3;
            c /= 2;
        }
        
        int l1 = str1.length() - 1;
        int l2 = str2.length() - 1;
        int l3 = str3.length() - 1;
        int max = Math.max(str1.length(), Math.max(str2.length(), str3.length()));
        
        while (l1 < max) {
            str1 = "0" + str1;
            l1++;
        }
        
        while (l2 < max) {
            str2 = "0" + str2;
            l2++;
        }
        
        while (l3 < max) {
            str3 = "0" + str3;
            l3++;
        }
                
        //System.out.println(str1);
        //System.out.println(str2);
        //System.out.println(str3);
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        char[] c3 = str3.toCharArray();
        
        int count = 0;
        while (l1 >= 0 && l2 >= 0 && l3 >= 0) {
            if (c1[l1] == '0' && c2[l2] == '0') {
                if (c3[l3] == '1') count++;
            } else if (c1[l1] == '1' && c2[l2] == '1') {
                if (c3[l3] == '0') count += 2;
            } else {
                if (c3[l3] == '0') count++;
            }
            
            l1--;
            l2--;
            l3--;
        }
        
        return count;
    }
}