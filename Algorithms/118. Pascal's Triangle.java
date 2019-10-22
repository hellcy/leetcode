class Solution {
    public List<List<Integer>> generate(int numRows) {
        /*
            Dynamic Programming
            for each sublist, use the previous sublist as a result
        */
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        
        for (int i = 0; i < numRows; ++i) {
            List<Integer> array = new ArrayList<Integer>();
            array.add(1);
            for (int j = 1; j < i; ++j) {
                array.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            if (i != 0) array.add(1);
            result.add(array);
        }
        return result;
    }
}