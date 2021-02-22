class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        /*
            Arrays
        */
        int start = 0;
        for (int[] cur : groups) {
            start = check(cur, nums, start);
            //System.out.println(start);
            if (start == -1) return false;
        }

        return true;
    }

    private int check(int[] arr1, int[] arr2, int start) {
        int index = start;
        while (index < arr2.length) {
            boolean found = false;
            for (int i = 0; i < arr1.length; ++i) {
                if (index + i >= arr2.length) return -1;
                if (arr1[i] != arr2[index + i]) {
                    found = true;
                    index += i;
                    if (i == 0) index++;
                    break;
                }
            }

            if (!found) return index + arr1.length;
        }

        return -1;
    }
}