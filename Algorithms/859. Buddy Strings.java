class Solution {
    public boolean buddyStrings(String A, String B) {
        /*
            Brute force
            HashMap
        */
        if (A.length() != B.length()) return false;
        Map<Integer, Character> mapA = new HashMap<>();
        Map<Integer, Character> mapB = new HashMap<>();
        
        boolean duplicateA = false, duplicateB = false;
        for (int i = 0; i < A.length(); ++i) {
            if (mapA.containsValue(A.charAt(i))) duplicateA = true;
            if (mapB.containsValue(B.charAt(i))) duplicateB = true;
            mapA.put(i, A.charAt(i));
            mapB.put(i, B.charAt(i));
        }
        
        int count = 0;
        char A1 = '0', A2 = '0', B1 = '0', B2 = '0';
        for (int i = 0; i < mapA.size(); ++i) {
            if (!mapA.get(i).equals(mapB.get(i))) {
                if (count == 0) {
                    A1 = mapA.get(i);
                    B1 = mapB.get(i);
                    count++;
                } else if (count == 1) {
                    A2 = mapA.get(i);
                    B2 = mapB.get(i);
                    count++;
                } else {
                    return false;
                }
            }
        }
        if (count == 0 && duplicateA == true && duplicateB == true) return true;
        if (count != 2) return false;
        if (A1 == B2 && A2 == B1) return true;
        else return false;
    }
}