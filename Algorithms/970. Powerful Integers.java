class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        /*
            Brute force
            HashSet
            Math
        */
        Set<Integer> setx  = new HashSet<>();
        Set<Integer> sety  = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        if (x == 1) {
            setx.add(1);
        } else {
             for (int i = 0; Math.pow(x, i) < bound; ++i) {
                setx.add((int)Math.pow(x, i));
            }   
        }
        
        if (y == 1) {
            sety.add(1);
        } else {
            for (int i = 0; Math.pow(y, i) < bound; ++i) {
                sety.add((int)Math.pow(y, i));
            }
        }
        
        for (int i = 2; i <= bound; ++i) {
            for (int j : setx) {
                if (sety.contains(i - j)) {
                    list.add(i);
                    break;
                }
            }
        }
        
        return list;
    }
}