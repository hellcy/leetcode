class Solution {
    public boolean rotateString(String A, String B) {
        /*
            Brute force
                rotate String A until it becomes A again
                check with String B each round
        */
        if (A.length() == 0 && B.length() == 0) return true;
        int k = 0;
        while (k < A.length()) {
            //System.out.println(rotate(A,k));
            if (B.equals(rotate(A, k))) return true;
            k++;
        }
        return false;
    }
    
    private String rotate(String A, int k) {
        StringBuilder B = new StringBuilder(A);
        
        for (int i = 0; i < A.length(); ++i) {
            B.setCharAt(i, A.charAt((i + A.length() - k) % A.length()));
        }
        
        return B.toString();
    }
}