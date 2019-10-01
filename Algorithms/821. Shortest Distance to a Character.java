class Solution {
    public int[] shortestToChar(String S, char C) {
        /*
            Array
            List
        */
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == C) {
                list.add(i);
            }
        }
        
        int[] array = new int[S.length()];
        Arrays.fill(array, Integer.MAX_VALUE); 
        for (int i = 0; i < S.length(); ++i) {
            for (int j = 0; j < list.size(); ++j) {
                array[i] = Math.min(array[i], Math.abs(list.get(j) - i));
            }
        }
        
        return array;
    }
}