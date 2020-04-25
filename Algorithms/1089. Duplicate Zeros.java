class Solution {
    public void duplicateZeros(int[] arr) {
        /*
            Algorithm explained:
                create a Arraylist
                adding values from arr to the array list
                when we come across zero, add it twice
                write back values from list to arr
        */
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 0) {
                list.add(0);
                list.add(0);
            } else {
                list.add(arr[i]);
            }
        }
        
        for (int i = 0; i < n; ++i) {
            arr[i] = list.get(i);
        }
        
    }
}