class Solution {
    public int hIndex(int[] citations) {
        int index = citations.length;
        
        while (index > 0) {
            int count = 0;
            for (int i : citations) {
                if (i >= index) {
                    count++;
                }
            }
            if (count >= index) return index;
            index--;
        }
        
        return 0;
    }
}