class Solution {
    public String getHint(String secret, String guess) {
        /*
            Hashset
        */
        int length = secret.length();
        int[] sarray = new int[length];
        int[] garray = new int[length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            sarray[i] = secret.charAt(i) - '0';
            garray[i] = guess.charAt(i) - '0';
            list.add(secret.charAt(i) - '0');
        }
        
        //System.out.println(set);
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < length; ++i) {
            if (sarray[i] == garray[i]) {
                bull++;
                list.remove(Integer.valueOf(garray[i]));
                garray[i] = -1;
            }
        }
        for (int i = 0; i < length; ++i) {
            if (garray[i] >= 0 && list.contains(garray[i])) {
                cow++;
                list.remove(Integer.valueOf(garray[i]));
            }
        }

        String ans = bull + "A" + cow + "B";
        return ans;
    }
}