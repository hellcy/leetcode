class Solution {
    public List<Integer> getRow(int rowIndex) {
        /*
            keep track of the current and prev list, add the previous list result to the current list
        */
        List<Integer> array = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            array.add(1);
            
            for (int j = 2; j < i; ++j) {
                array.set(j - 1, prev.get(0));
                prev.remove(0);
            }
            
            for (int j = 2; j <= i; ++j) {
                prev.add(array.get(j - 2) + array.get(j - 1));
            }
        }
        
        for (int j = 2; j < rowIndex + 1; ++j) {
            array.set(j - 1, prev.get(0));
            prev.remove(0);
        }
        return array;
    }
}