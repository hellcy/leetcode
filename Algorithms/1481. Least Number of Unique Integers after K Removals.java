class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int count = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] != arr[i - 1]) {
                list.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        
        list.add(count);
        
        System.out.println(list);
        
        Collections.sort(list);
        
        int index = 0;
        for (int i : list) {
            if (k >= i) {
                k = k - i;
                index++;
            } else {
                break;
            }
        }
        return list.size() - index;
    }
}