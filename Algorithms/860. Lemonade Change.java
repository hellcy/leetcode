class Solution {
    public boolean lemonadeChange(int[] bills) {
        /*
            Greedy
                when receive 20, first check if we have 10 left, return one 10 and one 5 notes first, 
                if we don't have 10, return three fives
        */
        int five = 0;
        int ten = 0;
        for (int i : bills) {
            if (i == 5) {
                five++;
            } else if (i == 10) {
                ten++;
                five--;
            } else if (i == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five = five - 3;
                }
            }
            
            if (five < 0 || ten < 0) return false;
        }
        return true;
    }
}