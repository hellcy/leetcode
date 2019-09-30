class Solution {
    public String complexNumberMultiply(String a, String b) {
        /*
            Brute force 
            String
            Math
        */
        String[] arraya = a.split("\\+");
        int a1 = Integer.parseInt(arraya[0]);
        int a2 = Integer.parseInt(arraya[1].substring(0, arraya[1].length() - 1));
        //System.out.println(a1 + " " + a2);
        
        String[] arrayb = b.split("\\+");
        int b1 = Integer.parseInt(arrayb[0]);
        int b2 = Integer.parseInt(arrayb[1].substring(0, arrayb[1].length() - 1));
        //System.out.println(b1 + " " + b2);

        String ans = (a1 * b1 - a2 * b2) + "+" + (a1 * b2 + a2 * b1) + "i";
        return ans;
    }
}