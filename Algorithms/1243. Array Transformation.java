class Solution {
    public List<Integer> transformArray(int[] arr) {
        /*
            array
        */
        int count = 1, length = arr.length;
        while (count > 0) {
            count = 0;
            int[] array = new int[length];
            array[0] = arr[0];
            array[length - 1] = arr[length - 1];
            
            for (int i = 1; i < length - 1; ++i) {
                if (arr[i - 1] > arr[i] && arr[i + 1] > arr[i]) {
                    count++;
                    array[i] = arr[i] + 1;
                } else if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                    count++;
                    array[i] = arr[i] - 1;
                } else array[i] = arr[i];
            }
            //System.out.println(array[1] + " " + array[2] + " " + count);

            arr = array;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            list.add(arr[i]);
        }
        return list;
    }
}