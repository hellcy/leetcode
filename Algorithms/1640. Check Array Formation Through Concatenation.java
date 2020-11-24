class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        
        for (int i = 0; i < arr.length; ++i) {
            if (!map.containsKey(arr[i])) return false;
            int[] temp = map.get(arr[i]);
            for (int j = i; j < i + temp.length; ++j) {
                if (arr[j] != temp[j - i]) return false;
            }
            i += temp.length - 1;
        }
        
        return true;
    }
}