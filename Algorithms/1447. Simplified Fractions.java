class Solution {
    public List<String> simplifiedFractions(int n) {
        /*
            GCD
        */
        List<String> list = new ArrayList<>();
        if (n <= 1) return list;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if (check(j, i) != 1) {
                    continue;
                } else {
                    list.add(String.valueOf(j) + "/" + String.valueOf(i));
                }
            }
        }
        
        return list;
    }
    
    private int check(int a, int b) {
        if (a == 0) 
            return b; 
        
        return check(b%a,a);
    }
}