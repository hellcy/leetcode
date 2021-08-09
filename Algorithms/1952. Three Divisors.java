class Solution {
    public boolean isThree(int n) {
        boolean found = false;
        for (int i = 2; i < n; ++i) {
            if (n % i == 0) {
                if (!found) {
                    found = true;
                } else {
                    return false;
                }
            }
        }
        
        return found;
    }
}