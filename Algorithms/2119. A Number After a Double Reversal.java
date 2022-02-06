class Solution {
    public boolean isSameAfterReversals(int num) {
        // return true if num doesn't have trailing zero or is zero
        return num == 0 || num % 10 != 0;
    }
}