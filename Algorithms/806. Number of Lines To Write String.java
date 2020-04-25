class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        /*
            String
            Array
        */
        char[] array = S.toCharArray();
        int count = 0;
        int last = 0;
        int unitcount = 0;
        int charnumber = 0;
        for (char c : array) {
            if (unitcount + widths[c - 'a'] > 100) {
                if (charnumber >= 1) {
                    count++;
                    last = unitcount;
                }
                unitcount = 0;
                charnumber = 0;
            }
            unitcount += widths[c - 'a'];
            charnumber++;
        }
        
        if (charnumber >= 1) {
            count++;
            last = unitcount;
        }
        return new int[] {count, last};
    }
}