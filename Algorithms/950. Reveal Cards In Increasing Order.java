class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        /*
            1. sort array in increasing order
            2. insert value into a new array one by one, make sure there is a empty slot in between inserts until you fill out the entire new array
        */
        Arrays.sort(deck);
        int length = deck.length;
        int availableSlots = length;
        int[] ans = new int[length];
        boolean[] slots = new boolean[length];
        boolean skip = false;
        int index = 0;
        for (int i : deck) {
            while (availableSlots > 0) {
                boolean hasValue = slots[index];
                if (!hasValue) {
                    if (!skip) {
                        ans[index] = i;
                        skip = true;
                        availableSlots--;
                        slots[index] = true;
                        break;
                    } else {
                        skip = false;
                    }
                }
                index++;
                if (index == length) index = 0;
            }
        }
        
        return ans;
    }
}